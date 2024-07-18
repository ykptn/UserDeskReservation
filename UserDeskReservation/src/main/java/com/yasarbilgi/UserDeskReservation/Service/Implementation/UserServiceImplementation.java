package com.yasarbilgi.UserDeskReservation.Service.Implementation;

import com.yasarbilgi.UserDeskReservation.DTO.LoginDTO;
import com.yasarbilgi.UserDeskReservation.DTO.PasswordResetDTO;
import com.yasarbilgi.UserDeskReservation.Exception.ResourceNotFoundException;
import com.yasarbilgi.UserDeskReservation.Mapper.UserMapper;
import com.yasarbilgi.UserDeskReservation.Message.LoginMessage;
import com.yasarbilgi.UserDeskReservation.Message.PasswordResetMessage;
import com.yasarbilgi.UserDeskReservation.Repository.UserRepository;
import com.yasarbilgi.UserDeskReservation.DTO.UserDTO;
import com.yasarbilgi.UserDeskReservation.Entity.User;
import com.yasarbilgi.UserDeskReservation.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserMapper::mapToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        return UserMapper.mapToUserDTO(user);
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = UserMapper.mapToUser(userDTO);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO updatedUserDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        user.setFirstName(updatedUserDTO.getFirstName());
        user.setLastName(updatedUserDTO.getLastName());
        user.setEmail(updatedUserDTO.getEmail());
        user.setPassword(updatedUserDTO.getPassword());
        User updatedUser = userRepository.save(user);
        return UserMapper.mapToUserDTO(updatedUser);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + userId));
        userRepository.delete(user);
    }

    @Override
    public LoginMessage login(LoginDTO loginDTO) {
        User user = userRepository.findByEmail(loginDTO.getEmail());
        if (user != null) {
            String password = loginDTO.getPassword();
            String storedPassword = user.getPassword();
            if (password.equals(storedPassword)) {
                return new LoginMessage("Login Success", true);
            } else {
                return new LoginMessage("Login Failed: Incorrect password", false);
            }
        } else {
            return new LoginMessage("Email not found", false);
        }
    }
    @Override
    public PasswordResetMessage resetPassword(PasswordResetDTO passwordResetDTO) {
        User user = userRepository.findByEmail(passwordResetDTO.getEmail());
        if (user == null) {
            return new PasswordResetMessage(false, "User not found!");
        }

        user.setPassword(passwordEncoder.encode(passwordResetDTO.getNewPassword()));
        userRepository.save(user);

        return new PasswordResetMessage(true, "Password successfully changed");
    }
}
