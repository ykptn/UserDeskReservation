package com.yasarbilgi.UserDeskReservation.Service;

import com.yasarbilgi.UserDeskReservation.DTO.ReservationDTO;
import java.util.List;

public interface ReservationService {
    ReservationDTO createReservation(ReservationDTO reservationDTO);
    ReservationDTO getReservationById(Long reservationId);
    List<ReservationDTO> getAllReservations();
    ReservationDTO updateReservation(Long reservationId, ReservationDTO updatedReservation);
    void deleteReservation(Long reservationId);
}