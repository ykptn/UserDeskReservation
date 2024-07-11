package com.yasarbilgi.UserDeskReservation.Service;

import com.yasarbilgi.UserDeskReservation.DTO.LoginDTO;
import com.yasarbilgi.UserDeskReservation.DTO.UserDTO;
import com.yasarbilgi.UserDeskReservation.LoginMesage;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserById(Long userId);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long userId, UserDTO updatedUser);
    void deleteUser(Long userId);
    LoginMesage login(LoginDTO loginDTO);
}


