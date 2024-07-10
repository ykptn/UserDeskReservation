package com.yasarbilgi.UserDeskReservation.Mapper;

import com.yasarbilgi.UserDeskReservation.DTO.UserDTO;
import com.yasarbilgi.UserDeskReservation.Entity.User;
import com.yasarbilgi.UserDeskReservation.Entity.Company;
import com.yasarbilgi.UserDeskReservation.Entity.Department;
import com.yasarbilgi.UserDeskReservation.Entity.UserRole;

public class UserMapper {

    public static UserDTO mapToUserDTO(User user) {
        return new UserDTO(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
                // Add mappings for company, department, userRole as needed
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword()
                // Set company, department, userRole based on DTO
        );
    }
}
