package com.tedbilgar.cookapp.repos;

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

    @Before
    public void before(){
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
    }

    @Test
    public void findUsersByFirstNameAndSecondNameTest() throws Exception{
        userRepository.save(UserEntity.builder().firstName("Test").secondName("Testov").build());

        List<UserEntity> userEntity = userRepositoryCustom.findUsersByFirstNameAndSecondName("Test","st");
        assertFalse(userEntity.isEmpty());
    }
}
