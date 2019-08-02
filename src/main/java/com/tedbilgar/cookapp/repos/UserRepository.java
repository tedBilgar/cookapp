package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.UserEntity;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CommonRepository<UserEntity,Long> {

    Optional<UserEntity> findById(Long userId);
    Optional<UserEntity> findByLogin(String login);
    Optional<List<UserEntity>> findByOccupationLike(String occupation);

    boolean existsById(Long userId);

    /**
     * Можно и нужно часто состявлять методы с Pageable. Например:
     * Optional<UserEntity> findByLogin(String login, Pageable pageable);
     * В сервисе можно просто подставить PageRequest.of(0,3, Sort.by("occupation").descending()),
     * где указывается номер пэйджа, кол-во данных, и сортировка по полю возрастанию/убыванию
     * */
}
