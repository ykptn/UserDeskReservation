package com.yasarbilgi.UserDeskReservation.Controller;

import com.yasarbilgi.UserDeskReservation.DTO.LoginDTO;
import com.yasarbilgi.UserDeskReservation.DTO.PasswordResetDTO;
import com.yasarbilgi.UserDeskReservation.DTO.UserDTO;
import com.yasarbilgi.UserDeskReservation.Message.LoginMessage;
import com.yasarbilgi.UserDeskReservation.Message.PasswordResetMessage;
import com.yasarbilgi.UserDeskReservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.createUser(userDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long userId) {
        UserDTO userDTO = userService.getUserById(userId);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        List<UserDTO> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long userId, @RequestBody UserDTO updatedUser) {
        UserDTO userDTO = userService.updateUser(userId, updatedUser);
        return ResponseEntity.ok(userDTO);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO){
        LoginMessage loginMessage = userService.login(loginDTO);
        if (loginMessage.getStatus()) {
            return ResponseEntity.ok(loginMessage);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(loginMessage);
        }
    }
    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestBody PasswordResetDTO passwordResetDTO) {
        PasswordResetMessage resetMessage = userService.resetPassword(passwordResetDTO);
        if (resetMessage.isSuccess()) {
            return ResponseEntity.ok(resetMessage);
        } else {
            return ResponseEntity.badRequest().body(resetMessage);
        }
    }
}