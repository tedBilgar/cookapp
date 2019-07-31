package com.tedbilgar.cookapp.repos.ext;

import com.tedbilgar.cookapp.entities.UserEntity;

import java.util.List;

/**
 * Кастомный интерфейс для UserEntity, когда
 * возможности пользоваться только возможностями Spring Data
 * создаются кастомные реализации репозиториев.
 * */
public interface UserRepositoryCustom {

    List<UserEntity> findUsersByFirstNameAndSecondName(String firstName, String secondName);
    List<UserEntity> findUsersByNoticeHeader(String noticeHeader);
}
