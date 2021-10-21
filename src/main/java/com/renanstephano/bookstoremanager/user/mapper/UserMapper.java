package com.renanstephano.bookstoremanager.user.mapper;

import com.renanstephano.bookstoremanager.user.dto.UserDTO;
import com.renanstephano.bookstoremanager.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User toModel(UserDTO userDTO);

    UserDTO toDTO(User user);
}
