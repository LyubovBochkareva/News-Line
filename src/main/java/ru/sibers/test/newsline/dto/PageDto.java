package ru.sibers.test.newsline.dto;

import java.util.List;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

public class PageDto<T> {
	private List<T> content;
	private Integer currentPage;
	private Integer itemsOnPage;
	private Integer pagesCount;

	public PageDto(Integer currentPage, Integer itemsOnPage) {
		this.currentPage = currentPage;
		this.itemsOnPage = itemsOnPage;
	}

	public List<T> getContent() {
		return content;
	}

	public void setContent(List<T> content) {
		this.content = content;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getItemsOnPage() {
		return itemsOnPage;
	}

	public void setItemsOnPage(Integer itemsOnPage) {
		this.itemsOnPage = itemsOnPage;
	}

	public Integer getPagesCount() {
		return pagesCount;
	}

	public void setPagesCount(Integer pagesCount) {
		this.pagesCount = pagesCount;
	}
}