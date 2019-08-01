package com.tedbilgar.cookapp.services.impl;

import com.tedbilgar.cookapp.repos.UserRepository;
import com.tedbilgar.cookapp.services.UserService;
import com.tedbilgar.cookapp.web.dto.UserDTO;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private UserRepository userRepository;

    @Override
    public List<UserDTO> listUsersByOccupation(List<String> occupations) {
        return null;
    }
}
