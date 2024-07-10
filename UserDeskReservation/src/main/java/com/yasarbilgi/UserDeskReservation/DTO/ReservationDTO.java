package com.yasarbilgi.UserDeskReservation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDTO {
    private Long id;
    private Long deskId;
    private Long userId;
    private LocalDate reservationDate;
}
