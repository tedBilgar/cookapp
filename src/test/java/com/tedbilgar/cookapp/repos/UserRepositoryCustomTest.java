package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.NoticeEntity;
import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.repos.ext.UserRepositoryCustom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootApplication(scanBasePackages = "com.tedbilgar.cookapp", excludeName = "com.tedbilgar.cookapp.entities")
@EntityScan(basePackages = "com.tedbilgar.cookapp.entities")
public class UserRepositoryCustomTest {

    @Autowired
    private UserRepositoryCustom userRepositoryCustom;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NoticeRepository noticeRepository;

    private static boolean dbInit = false;

    @Before
    public void before(){
        if(!dbInit) {
            userRepository.save(
                    UserEntity.builder()
                            .id(1L)
                            .login("TestLogin")
                            .firstName("Test")
                            .secondName("Testov")
                            .occupation("Programming")
                            .build()
            );
            userRepository.save(
                    UserEntity.builder()
                            .id(2L)
                            .login("TestLogin2")
                            .firstName("Test2")
                            .secondName("Testov2")
                            .occupation("Football")
                            .build()
            );
            userRepository.save(
                    UserEntity.builder()
                            .id(3L)
                            .login("TestLogin3")
                            .firstName("Tes3t")
                            .secondName("Testov3")
                            .occupation("Healing")
                            .build()
            );

            NoticeEntity noticeEntity1 = NoticeEntity.builder().id(1L).header("Main_Header").body("Main_Body").build();
            NoticeEntity noticeEntity2 = NoticeEntity.builder().id(2L).header("Second_Header").body("Second_Body").build();

            noticeRepository.save(noticeEntity1);
            noticeRepository.save(noticeEntity2);

            userRepository.save(
                    UserEntity.builder()
                            .id(4L)
                            .login("TestLogin4")
                            .firstName("Test4")
                            .secondName("Testov4")
                            .occupation("Healing")
                            .noticeEntitySet(new HashSet<>(Arrays.asList(noticeEntity1, noticeEntity2)))
                            .build()
            );
            userRepository.save(
                    UserEntity.builder()
                            .id(5L)
                            .login("TestLogin5")
                            .firstName("Test5")
                            .secondName("Testov5")
                            .occupation("Healing")
                            .noticeEntitySet(new HashSet<>(Arrays.asList(noticeEntity1, noticeEntity2)))
                            .build()
            );
            dbInit = true;
        }
    }

    @Test
    public void findUsersByFirstNameAndSecondNameTest() throws Exception{
        List<UserEntity> userEntity = userRepositoryCustom.findUsersByFirstNameAndSecondName("Test","st");
        assertFalse(userEntity.isEmpty());
    }

    @Test
    public void findUsersByNoticeHeaderTest() throws Exception {
        assertFalse(userRepositoryCustom.findUsersByNoticeHeader("Ma").isEmpty());
        assertEquals(2,userRepositoryCustom.findUsersByNoticeHeader("Hea").size());
    }
}
