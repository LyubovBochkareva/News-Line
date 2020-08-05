package ru.sibers.test.newsline.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import ru.sibers.test.newsline.entity.News;

/**
 * @author Lyubov Bochkareva
 * @since 05.05.2020
 */

public interface NewsRepository extends PagingAndSortingRepository<News, Long>, NewsRepositoryCustom {

}