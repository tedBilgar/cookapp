package com.tedbilgar.cookapp.mappers;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Если все поля ДТО и энтити идентичны по названиям,
     * то достаточно указать @Mapper и сигнатуры функций маппинга.
     * Если ситуация сложнее (названия различны, или нужно пару полей энтити запихнуть
     * в одно поле ДТО), то необходимы строить @Mappings.
     * Необязательно указывать все филды, достаточно те, которые различаются.
     * Если нужно преобразовать несколько филдов в один филд другого класса испольуется @AfterMapping
     * */
    @Mappings(
            @Mapping(target="occupationDTO", source = "userEntity.occupation")
    )
    UserDTO userEntityToUserDto(UserEntity userEntity);
    @Mappings(
            @Mapping(target="occupation", source = "userDTO.occupationDTO")
    )
    UserEntity userDtoToUserEntity(UserDTO userDTO);

    /**
     * Из UserEntity -> UserDTO соединяем в полное имя при маппинге
     * */
    @AfterMapping
    default void setFullName(@MappingTarget UserDTO userDTO, UserEntity userEntity){
        userDTO.setFullName(userEntity.getFirstName() + " " + userEntity.getSecondName());
    }

    /**
     * Из UserDTO -> UserEntity разделям полное имя на состовляющие
     * */
    @AfterMapping
    default void splitFullName(@MappingTarget UserEntity userEntity, UserDTO userDTO){
        userEntity.setFirstName(userDTO.getFullName().split(" ")[0]);
        userEntity.setSecondName(userDTO.getFullName().split(" ")[1]);
    }
}
