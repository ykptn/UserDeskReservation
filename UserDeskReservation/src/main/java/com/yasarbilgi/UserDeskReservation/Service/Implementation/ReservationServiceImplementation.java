package com.yasarbilgi.UserDeskReservation.Service.Implementation;

import com.yasarbilgi.UserDeskReservation.Exception.ResourceNotFoundException;
import com.yasarbilgi.UserDeskReservation.Mapper.ReservationMapper;
import com.yasarbilgi.UserDeskReservation.Repository.ReservationRepository;
import com.yasarbilgi.UserDeskReservation.DTO.ReservationDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Reservation;
import com.yasarbilgi.UserDeskReservation.Service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImplementation implements ReservationService {

    private final ReservationRepository reservationRepository;

    @Autowired
    public ReservationServiceImplementation(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    @Transactional
    public ReservationDTO createReservation(ReservationDTO reservationDTO) {
        Reservation reservation = ReservationMapper.mapToReservation(reservationDTO);
        Reservation savedReservation = reservationRepository.save(reservation);
        return ReservationMapper.mapToReservationDTO(savedReservation);
    }

    @Override
    @Transactional
    public ReservationDTO updateReservation(Long reservationId, ReservationDTO updatedReservationDTO) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));
        reservation.setReservationDate(updatedReservationDTO.getReservationDate());
        Reservation updatedReservation = reservationRepository.save(reservation);
        return ReservationMapper.mapToReservationDTO(updatedReservation);
    }

    @Override
    public void deleteReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));
        reservationRepository.delete(reservation);
    }

    @Override
    public List<ReservationDTO> getAllReservations() {
        return reservationRepository.findAll().stream()
                .map(ReservationMapper::mapToReservationDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservationDTO getReservationById(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reservation not found with id: " + reservationId));
        return ReservationMapper.mapToReservationDTO(reservation);
    }
}