package com.tedbilgar.cookapp.services.impl;

import com.tedbilgar.cookapp.mappers.UserMapper;
import com.tedbilgar.cookapp.repos.UserRepository;
import com.tedbilgar.cookapp.services.UserService;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private UserRepository userRepository;

    @NonNull
    private UserMapper userMapper;

    @Override
    public List<UserDTO> listUsersByOccupation(String occupation) {
        //test
        int a = 2 + 4;
        return userRepository.findByOccupationLike(occupation)
                .orElseThrow(RuntimeException::new)
                .stream()
                .map(userEntity -> userMapper.userEntityToUserDto(userEntity))
                .collect(Collectors.toList());
    }
}
