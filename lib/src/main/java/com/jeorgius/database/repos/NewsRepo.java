package com.jeorgius.database.repos;


import com.jeorgius.database.entities.NewsItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface NewsRepo extends CrudRepository<NewsItem, Long> {
    List<NewsItem> findAll();
    NewsItem findOneById(Long id);
    NewsItem findFirstByOrderByIdDesc();

}
