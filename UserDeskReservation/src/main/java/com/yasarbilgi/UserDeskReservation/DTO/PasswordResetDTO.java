package com.yasarbilgi.UserDeskReservation.DTO;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordResetDTO {
    private String email;
    private String newPassword;
}
