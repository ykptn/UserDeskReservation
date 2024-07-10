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
                user.getPassword(),
                user.getCompany() != null ? user.getCompany().getId() : null,
                user.getDepartment() != null ? user.getDepartment().getId() : null,
                user.getUserRole() != null ? user.getUserRole().getId() : null
        );
    }

    public static User mapToUser(UserDTO userDTO) {
        Company company = null;
        if (userDTO.getCompanyId() != null) {
            company = new Company();
            company.setId(userDTO.getCompanyId());
        }

        Department department = null;
        if (userDTO.getDepartmentId() != null) {
            department = new Department();
            department.setId(userDTO.getDepartmentId());
        }

        UserRole userRole = null;
        if (userDTO.getUserRoleId() != null) {
            userRole = new UserRole();
            userRole.setId(userDTO.getUserRoleId());
        }
        return new User(
                userDTO.getId(),
                userDTO.getFirstName(),
                userDTO.getLastName(),
                userDTO.getEmail(),
                userDTO.getPassword(),
                company,
                department,
                userRole
        );
    }
}
