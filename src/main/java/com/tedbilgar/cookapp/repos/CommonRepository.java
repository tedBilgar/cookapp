package com.tedbilgar.cookapp.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Необходимый общий репозиторий для работы
 * с сущностями из БД для любого проекта.
 *
 * JPARepo необходима для CRUD + Page запросов
 *
 * JPASpecExec необходим для создания собственных запросов с Criteria API
 *
 * */

@NoRepositoryBean
public interface CommonRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {
}
