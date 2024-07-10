package com.yasarbilgi.UserDeskReservation.Service.Implementation;

import com.yasarbilgi.UserDeskReservation.DTO.UserRoleDTO;
import com.yasarbilgi.UserDeskReservation.Entity.UserRole;
import com.yasarbilgi.UserDeskReservation.Exception.ResourceNotFoundException;
import com.yasarbilgi.UserDeskReservation.Mapper.UserRoleMapper;
import com.yasarbilgi.UserDeskReservation.Repository.UserRoleRepository;
import com.yasarbilgi.UserDeskReservation.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserRoleServiceImplementation implements UserRoleService {

    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserRoleServiceImplementation(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public UserRoleDTO createUserRole(UserRoleDTO userRoleDTO) {
        UserRole userRole = UserRoleMapper.mapToUserRole(userRoleDTO);
        UserRole savedUserRole = userRoleRepository.save(userRole);
        return UserRoleMapper.mapToUserRoleDTO(savedUserRole);
    }

    @Override
    public UserRoleDTO updateUserRole(Long userRoleId, UserRoleDTO updatedUserRoleDTO) {
        UserRole userRole = userRoleRepository.findById(userRoleId)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole not found with id: " + userRoleId));
        userRole.setRoleName(updatedUserRoleDTO.getRoleName());
        UserRole updatedUserRole = userRoleRepository.save(userRole);
        return UserRoleMapper.mapToUserRoleDTO(updatedUserRole);
    }

    @Override
    public void deleteUserRole(Long userRoleId) {
        UserRole userRole = userRoleRepository.findById(userRoleId)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole not found with id: " + userRoleId));
        userRoleRepository.delete(userRole);
    }

    @Override
    public List<UserRoleDTO> getAllUserRoles() {
        return userRoleRepository.findAll().stream()
                .map(UserRoleMapper::mapToUserRoleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserRoleDTO getUserRoleById(Long userRoleId) {
        UserRole userRole = userRoleRepository.findById(userRoleId)
                .orElseThrow(() -> new ResourceNotFoundException("UserRole not found with id: " + userRoleId));
        return UserRoleMapper.mapToUserRoleDTO(userRole);
    }
}

