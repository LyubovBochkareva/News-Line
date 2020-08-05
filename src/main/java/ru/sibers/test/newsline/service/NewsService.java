package ru.sibers.test.newsline.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.sibers.test.newsline.dto.PageDto;
import ru.sibers.test.newsline.dto.ServerResp;
import ru.sibers.test.newsline.entity.News;
import ru.sibers.test.newsline.handler.exception.ApiError;
import ru.sibers.test.newsline.repository.NewsRepository;

import javax.validation.ConstraintViolationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@Service
public class NewsService {

	private final NewsRepository newsRepository;

	@Value("${upload.path}")
	private String uploadPath;

	public NewsService(NewsRepository newsRepository) {
		this.newsRepository = newsRepository;
	}

	/**
	 * Returns a PageDto object consisting of a limited list("itemsOnPage") of news on the selected page("pageNumber").
	 *
	 * @param pageNumber  the selected page
	 * @param itemsOnPage count of news per the select page
	 * @return PageDto object with a given page number and amount of news
	 */
	public PageDto<News> getPage(Integer pageNumber, Integer itemsOnPage) {
		PageDto<News> pageDto = new PageDto<>(pageNumber, itemsOnPage);
		long count = newsRepository.count();
		pageDto.setContent(newsRepository.getItemsForPage(pageNumber, itemsOnPage));
		pageDto.setPagesCount((int) (count == 0 ? 0 : count / itemsOnPage + 1));
		return pageDto;
	}

	/**
	 * Save file in the added news.
	 *
	 * @param news news to be added
	 * @param file picture for news
	 */
	private void saveFile(News news, MultipartFile file) throws IOException {
		if (!(file.getContentType().contains("image"))) {
			throw new IllegalArgumentException("Unsupported file type");
		}
		String uuidFile = UUID.randomUUID().toString();
		String resultFilename = uuidFile + "." + file.getOriginalFilename();
		file.transferTo(new File(uploadPath + "/" + resultFilename));
		news.setFilename(resultFilename);
	}

	/**
	 * Adding a new news item
	 *
	 * @param news news to be added
	 * @param file picture for news
	 * @return ServerResp object with a given news and file
	 */
	public ServerResp addNews(News news, MultipartFile file) {
		ApiError apiError = new ApiError(HttpStatus.OK);
		try {
			if (file.getOriginalFilename() != null && !file.isEmpty()) {
				saveFile(news, file);
			}
			news.setPublicationDate(LocalDateTime.now());
			newsRepository.save(news);
		} catch (ConstraintViolationException e) {
			apiError.setMessage("Fill in required fields");
			apiError.setStatus(HttpStatus.BAD_REQUEST);
			return new ServerResp(null, apiError);
		} catch (IOException | IllegalArgumentException ex) {
			apiError.setMessage(ex.getMessage());
			apiError.setStatus(HttpStatus.BAD_REQUEST);
			return new ServerResp(null, apiError);
		}
		return new ServerResp(news, apiError);
	}
}