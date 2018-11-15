package com.jeorgius.cfg.Repos;

import com.jeorgius.cfg.Entities.Users.User;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface UserRepo extends CrudRepository<User, Long> {
    List<User> findAll();
    User findOneById(Long id);
    User findFirstByOrderByIdDesc();
    User findOneByNickname(String nickname);
}
