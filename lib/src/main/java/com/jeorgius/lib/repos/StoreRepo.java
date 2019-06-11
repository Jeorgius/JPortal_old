package com.jeorgius.lib.repos;

import com.jeorgius.lib.entities.Store.StoreItem;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface StoreRepo extends CrudRepository<StoreItem, Long> {
    List<StoreItem> findAll();
    StoreItem findOneById(Long id);
}
