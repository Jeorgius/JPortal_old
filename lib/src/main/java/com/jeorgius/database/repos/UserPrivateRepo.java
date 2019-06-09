package com.jeorgius.database.repos;


import com.jeorgius.database.entities.Users.UserPrivate;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserPrivateRepo extends CrudRepository<UserPrivate, Long> {
    UserPrivate findOneByEmail(String email);
}
