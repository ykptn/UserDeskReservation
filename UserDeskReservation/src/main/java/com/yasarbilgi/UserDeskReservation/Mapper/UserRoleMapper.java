package com.yasarbilgi.UserDeskReservation.Mapper;

import com.yasarbilgi.UserDeskReservation.DTO.UserRoleDTO;
import com.yasarbilgi.UserDeskReservation.Entity.UserRole;

public class UserRoleMapper {

    public static UserRoleDTO mapToUserRoleDTO(UserRole userRole) {
        return new UserRoleDTO(
                userRole.getId(),
                userRole.getRoleName()
        );
    }

    public static UserRole mapToUserRole(UserRoleDTO userRoleDTO) {
        return new UserRole(
                userRoleDTO.getId(),
                userRoleDTO.getRoleName()
        );
    }
}