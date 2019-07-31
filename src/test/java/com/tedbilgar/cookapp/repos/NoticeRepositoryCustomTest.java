package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.NoticeEntity;
import com.tedbilgar.cookapp.repos.ext.NoticeRepositoryCustom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "com.tedbilgar.cookapp", excludeName = "com.tedbilgar.cookapp.entities")
@EntityScan(basePackages = "com.tedbilgar.cookapp.entities")
public class NoticeRepositoryCustomTest {

    @Autowired
    private NoticeRepository noticeRepository;
    @Autowired
    private NoticeRepositoryCustom noticeRepositoryCustom;

    @Before
    public void before(){
        noticeRepository.save(
                NoticeEntity.builder()
                        .id(1L)
                        .header("test123")
                        .body("firstNotice")
                        .build()
        );
        noticeRepository.save(
                NoticeEntity.builder()
                        .id(2L)
                        .header("test123")
                        .body("secondNotice")
                        .build()
        );
        noticeRepository.save(
                NoticeEntity.builder()
                        .id(3L)
                        .header("test123")
                        .body("thirdNotice")
                        .build()
        );
    }

    @Test
    public void findNoticeByHeaderAndBodyTest() throws Exception {
        assertFalse(noticeRepositoryCustom.findNoticeByHeaderAndBody("","").isEmpty());
        assertFalse(noticeRepositoryCustom.findNoticeByHeaderAndBody("test123","rd").isEmpty());
        assertTrue(noticeRepositoryCustom.findNoticeByHeaderAndBody("543","").isEmpty());
    }

}
