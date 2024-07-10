package com.yasarbilgi.UserDeskReservation.Service;

import com.yasarbilgi.UserDeskReservation.DTO.UserRoleDTO;
import java.util.List;

public interface UserRoleService {
    UserRoleDTO createUserRole(UserRoleDTO userRoleDTO);
    UserRoleDTO getUserRoleById(Long userRoleId);
    List<UserRoleDTO> getAllUserRoles();
    UserRoleDTO updateUserRole(Long userRoleId, UserRoleDTO updatedUserRole);
    void deleteUserRole(Long userRoleId);
}
