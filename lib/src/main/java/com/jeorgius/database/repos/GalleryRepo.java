package com.jeorgius.database.repos;


import com.jeorgius.database.entities.GalleryItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface GalleryRepo extends CrudRepository<GalleryItem, Long> {
    List<GalleryItem> findAll();
    GalleryItem findOneById(Long id);
}