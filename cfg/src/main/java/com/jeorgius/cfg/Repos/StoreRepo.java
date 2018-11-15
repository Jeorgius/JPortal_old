package com.jeorgius.cfg.Repos;

import com.jeorgius.cfg.Entities.Store.StoreItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StoreRepo extends CrudRepository<StoreItem, Long> {
    List<StoreItem> findAll();
    StoreItem findOneById(Long id);
}
