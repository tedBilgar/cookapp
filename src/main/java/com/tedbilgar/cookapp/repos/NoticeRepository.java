package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.NoticeEntity;

public interface NoticeRepository extends CommonRepository<NoticeEntity, Long> {

    boolean existsById(Long id);

}
