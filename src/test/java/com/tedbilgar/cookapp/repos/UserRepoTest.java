package com.tedbilgar.cookapp.repos;

import com.tedbilgar.cookapp.entities.UserEntity;
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
public class UserRepoTest {
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
    public void createUserTest() throws Exception{
        assertNotNull(userRepository.save(new UserEntity()));
    }

    @Test
    public void findAllUsersTest() throws Exception{
        assertNotNull(userRepository.findAll());
    }

    @Test
    public void findUserTest() throws Exception{
        assertNotNull(userRepository.findById(1L));
    }

    @Test
    public void deleteUserTest() throws Exception{
        UserEntity userEntity = userRepository.save(new UserEntity());
        userRepository.delete(userEntity);
    }

    @Test
    public void findByIdTest() throws Exception{
        UserEntity userEntityFromDB = userRepository.findById(2L).orElseThrow(RuntimeException::new);
        assertEquals(userRepository.findById(2L).orElseThrow(RuntimeException::new).getId(), userEntityFromDB.getId());
    }

    @Test
    public void findByLoginTest() throws Exception{
        UserEntity userEntity = userRepository.save(UserEntity.builder().login("Test").build());
        assertNotNull(userRepository.findByLogin(userEntity.getLogin()).orElseThrow(RuntimeException::new));
    }

    @Test
    public void existByIdTest()throws Exception{
        UserEntity userEntity = userRepository.save(new UserEntity());
        assertTrue(userRepository.existsById(userEntity.getId()));
    }

}
