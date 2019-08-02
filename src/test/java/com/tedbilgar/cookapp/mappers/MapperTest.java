package com.tedbilgar.cookapp.mappers;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class MapperTest {

    @TestConfiguration
    static class UserMapperConfiguration{
        @Bean
        public UserMapper userMapper(){
            return new UserMapperImpl();
        }
    }

    @Autowired
    private UserMapper userMapper;

    @Test
    public void UserMapperTest() throws Exception{
        UserEntity userEntity = UserEntity.builder()
                .id(1L)
                .firstName("Test")
                .secondName("Testov")
                .login("Test123")
                .occupation("qwe").build();
        UserDTO userDTO = userMapper.userEntityToUserDto(userEntity);

        assertEquals(userEntity.getLogin(), userDTO.getLogin());
        assertEquals(userEntity.getFirstName() + " " + userEntity.getSecondName(), userDTO.getFullName());

        UserEntity userEntityReverse = userMapper.userDtoToUserEntity(userDTO);
        assertEquals(userDTO.getLogin(), userEntityReverse.getLogin());
        assertEquals(userEntityReverse.getFirstName(), userEntity.getFirstName());
    }
}
