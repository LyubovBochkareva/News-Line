package ru.sibers.test.newsline.repository;

import org.springframework.stereotype.Repository;
import ru.sibers.test.newsline.entity.News;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

@Repository
public class NewsRepositoryImpl implements NewsRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Returns a list of news with size("itemsOnPage") on the selected page("page").
	 *
	 * @param pageNumber  the selected page
	 * @param itemsOnPage count of news per the select page
	 * @return a list of news with size("itemsOnPage") on the selected page("page")
	 */
	@Override
	public List<News> getItemsForPage(Integer pageNumber, Integer itemsOnPage) {
		return em
				.createQuery("SELECT news FROM News as news order by news.publicationDate desc", News.class)
				.setFirstResult((pageNumber - 1) * itemsOnPage)
				.setMaxResults(itemsOnPage)
				.getResultList();
	}
}