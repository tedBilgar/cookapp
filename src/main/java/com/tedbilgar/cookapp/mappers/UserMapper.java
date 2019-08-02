package com.tedbilgar.cookapp.mappers;

import com.tedbilgar.cookapp.entities.UserEntity;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Если все поля ДТО и энтити идентичны по названиям,
     * то достаточно указать @Mapper и сигнатуры функций маппинга.
     * Если ситуация сложнее (названия различны, или нужно пару полей энтити запихнуть
     * в одно поле ДТО), то необходимы строить @Mappings.
     * Необязательно указывать все филды, достаточно те, которые различаются.
     * */
    @Mappings(
            @Mapping(target="occupationDTO", source = "userEntity.occupation")
    )
    UserDTO userEntityToUserDto(UserEntity userEntity);
    @Mappings(
            @Mapping(target="occupation", source = "userDTO.occupationDTO")
    )
    UserEntity userDtoToUserEntity(UserDTO userDTO);
}
