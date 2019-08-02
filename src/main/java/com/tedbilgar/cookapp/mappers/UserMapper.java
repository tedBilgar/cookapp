package com.tedbilgar.cookapp.mappers;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userEntityToUserDto(UserEntity userEntity);
    UserEntity userDtoToUserEntity(UserDTO userDTO);
}
