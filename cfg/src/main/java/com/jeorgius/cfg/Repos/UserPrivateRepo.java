package com.jeorgius.cfg.Repos;


import com.jeorgius.cfg.Entities.Users.UserPrivate;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserPrivateRepo extends CrudRepository<UserPrivate, Long> {
    UserPrivate findOneByEmail(String email);
}
