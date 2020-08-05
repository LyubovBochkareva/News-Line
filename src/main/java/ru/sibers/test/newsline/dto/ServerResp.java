package ru.sibers.test.newsline.dto;

import ru.sibers.test.newsline.entity.News;
import ru.sibers.test.newsline.handler.exception.ApiError;

/**
 * @author Lyubov Bochkareva
 * @since 31.07.20.
 */

public class ServerResp {

	private News news;
	private ApiError apiError;

	public ServerResp(News news, ApiError apiError) {
		this.news = news;
		this.apiError = apiError;
	}

	public News getNews() {
		return news;
	}

	public void setNews(News news) {
		this.news = news;
	}

	public ApiError getApiError() {
		return apiError;
	}

	public void setApiError(ApiError apiError) {
		this.apiError = apiError;
	}
}
