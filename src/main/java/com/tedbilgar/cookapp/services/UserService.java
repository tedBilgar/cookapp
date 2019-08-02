package com.tedbilgar.cookapp.services;

import com.tedbilgar.cookapp.web.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> listUsersByOccupation(String occupation);
}
