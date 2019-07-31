package com.tedbilgar.cookapp.repos.ext;

import com.tedbilgar.cookapp.entities.NoticeEntity;

import java.util.List;

public interface NoticeRepositoryCustom {

    List<NoticeEntity> findNoticeByHeaderAndBody(String header, String body);
}
