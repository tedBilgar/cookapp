package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.NoticeEntity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "com.tedbilgar.cookapp", excludeName = "com.tedbilgar.cookapp.entities")
@EntityScan(basePackages = "com.tedbilgar.cookapp.entities")
public class NoticeRepositoryTest {

    @Autowired
    private NoticeRepository noticeRepository;

    @Before
    public void before(){
        noticeRepository.save(
                NoticeEntity.builder()
                    .id(1L)
                    .header("test123")
                    .body("test123123123")
                    .build()
        );
        noticeRepository.save(
                NoticeEntity.builder()
                        .id(2L)
                        .header("test123")
                        .body("test123123123")
                        .build()
        );
        noticeRepository.save(
                NoticeEntity.builder()
                        .id(3L)
                        .header("test123")
                        .body("test123123123")
                        .build()
        );
    }

    @Test
    public void createNoticeTest() throws Exception{
        assertNotNull(noticeRepository.save(new NoticeEntity()));
    }

    @Test
    public void findAllNoticesTest() throws Exception{
        assertFalse(noticeRepository.findAll().isEmpty());
    }

    @Test
    public void findNoticeByIdTest() throws Exception{
        assertNotNull(noticeRepository.findById(1L).orElseThrow(RuntimeException::new));
    }

    @Test
    public void deleteNoticeTest() throws Exception{
        NoticeEntity noticeEntity = noticeRepository.findById(2L).orElseThrow(RuntimeException::new);
        noticeRepository.delete(noticeEntity);
    }

    @Test
    public void existsByIdTest() throws Exception{
        assertTrue(noticeRepository.existsById(1L));
    }

}
