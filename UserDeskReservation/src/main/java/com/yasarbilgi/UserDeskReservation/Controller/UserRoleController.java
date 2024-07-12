package com.yasarbilgi.UserDeskReservation.Controller;

import com.yasarbilgi.UserDeskReservation.DTO.UserRoleDTO;
import com.yasarbilgi.UserDeskReservation.Service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/userRoles")
public class UserRoleController {

    private final UserRoleService userRoleService;

    @Autowired
    public UserRoleController(UserRoleService userRoleService) {
        this.userRoleService = userRoleService;
    }

    @PostMapping
    public ResponseEntity<UserRoleDTO> createUserRole(@RequestBody UserRoleDTO userRoleDTO) {
        UserRoleDTO createdUserRole = userRoleService.createUserRole(userRoleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUserRole);
    }

    @GetMapping("/{userRoleId}")
    public ResponseEntity<UserRoleDTO> getUserRoleById(@PathVariable Long userRoleId) {
        UserRoleDTO userRoleDTO = userRoleService.getUserRoleById(userRoleId);
        return ResponseEntity.ok(userRoleDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserRoleDTO>> getAllUserRoles() {
        List<UserRoleDTO> userRoles = userRoleService.getAllUserRoles();
        return ResponseEntity.ok(userRoles);
    }

    @PutMapping("/{userRoleId}")
    public ResponseEntity<UserRoleDTO> updateUserRole(@PathVariable Long userRoleId, @RequestBody UserRoleDTO updatedUserRole) {
        UserRoleDTO userRoleDTO = userRoleService.updateUserRole(userRoleId, updatedUserRole);
        return ResponseEntity.ok(userRoleDTO);
    }

    @DeleteMapping("/{userRoleId}")
    public ResponseEntity<Void> deleteUserRole(@PathVariable Long userRoleId) {
        userRoleService.deleteUserRole(userRoleId);
        return ResponseEntity.noContent().build();
    }
}