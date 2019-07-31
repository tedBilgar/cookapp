package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<UserEntity,Long> {

    Optional<UserEntity> findById(Long userId);
    Optional<UserEntity> findByLogin(String login);

    boolean existsById(Long userId);
}
