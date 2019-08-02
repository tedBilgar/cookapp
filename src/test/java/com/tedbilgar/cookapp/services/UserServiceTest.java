package com.tedbilgar.cookapp.services;

import com.tedbilgar.cookapp.mappers.UserMapper;
import com.tedbilgar.cookapp.repos.UserRepository;
import com.tedbilgar.cookapp.services.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserServiceTest {

    @TestConfiguration
    static class UserServiceTestConfiguration {
        @Bean
        public UserService userService(){
            return new UserServiceImpl();
        }
    }

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @MockBean
    private UserMapper userMapper;

    @Test
    public void listUsersByOccupationTest() throws Exception {
        Assert.assertNotNull(userService.listUsersByOccupation(""));
    }
}
