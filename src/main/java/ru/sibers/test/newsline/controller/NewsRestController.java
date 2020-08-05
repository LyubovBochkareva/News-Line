package ru.sibers.test.newsline.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.sibers.test.newsline.dto.PageDto;
import ru.sibers.test.newsline.dto.ServerResp;
import ru.sibers.test.newsline.entity.News;
import ru.sibers.test.newsline.service.NewsService;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@RestController
public class NewsRestController {

	private NewsService newsService;

	@Value("${upload.path}")
	private String uploadPath;

	public NewsRestController(NewsService newsService) {
		this.newsService = newsService;
	}

	/**
	 * Returns a PageDto object consisting of a limited list("size") of news on the selected page("page").
	 *
	 * @param page the selected page
	 * @param size count of news per the select page
	 * @return PageDto object with a given page number and amount of news
	 */
	@GetMapping("/news")
	public PageDto<News> findPaginated(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		return newsService.getPage(page, size);
	}

	/**
	 * Returns the result of adding a new news item.
	 *
	 * @param news news to be added
	 * @param file picture for news
	 * @return ServerResp object for added news and file
	 */
	@PostMapping("/news/add")
	public ResponseEntity<?> add(News news, @RequestParam("file") MultipartFile file) {
		ServerResp serverResp = newsService.addNews(news, file);
		return serverResp.getNews() != null ?
				new ResponseEntity<>(serverResp.getNews(), HttpStatus.OK) :
				new ResponseEntity<>(serverResp.getApiError().getMessage(), serverResp.getApiError().getStatus());
	}
}