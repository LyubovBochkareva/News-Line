package ru.sibers.test.newsline.repository;

import ru.sibers.test.newsline.entity.News;

import java.util.List;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

public interface NewsRepositoryCustom {

	/**
	 * Returns a list of news with size("itemsOnPage") on the selected page("page").
	 *
	 * @param pageNumber  the selected page
	 * @param itemsOnPage count of news per the select page
	 * @return a list of news with size("itemsOnPage") on the selected page("page")
	 */
	List<News> getItemsForPage(Integer pageNumber, Integer itemsOnPage);
}