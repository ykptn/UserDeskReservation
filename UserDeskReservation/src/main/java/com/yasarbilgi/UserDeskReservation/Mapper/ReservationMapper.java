package com.yasarbilgi.UserDeskReservation.Mapper;

import com.yasarbilgi.UserDeskReservation.DTO.ReservationDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Reservation;

public class ReservationMapper {

    public static ReservationDTO mapToReservationDTO(Reservation reservation) {
        return new ReservationDTO(
                reservation.getId(),
                reservation.getDesk().getId(),
                reservation.getUser().getId(),
                reservation.getReservationDate()
        );
    }

    public static Reservation mapToReservation(ReservationDTO reservationDTO) {
        Reservation reservation = new Reservation();
        reservation.setId(reservationDTO.getId());
        reservation.setReservationDate(reservationDTO.getReservationDate());
        return reservation;
    }
}