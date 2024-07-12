package com.yasarbilgi.UserDeskReservation.Service.Implementation;

import com.yasarbilgi.UserDeskReservation.Exception.ResourceNotFoundException;
import com.yasarbilgi.UserDeskReservation.Mapper.DeskMapper;
import com.yasarbilgi.UserDeskReservation.Repository.DeskRepository;
import com.yasarbilgi.UserDeskReservation.DTO.DeskDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Desk;
import com.yasarbilgi.UserDeskReservation.Service.DeskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DeskServiceImplementation implements DeskService {

    private final DeskRepository deskRepository;

    @Autowired
    public DeskServiceImplementation(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    @Override
    public List<DeskDTO> getAllDesks() {
        return deskRepository.findAll().stream()
                .map(DeskMapper::mapToDeskDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DeskDTO getDeskById(Long deskId) {
        Desk desk = deskRepository.findById(deskId)
                .orElseThrow(() -> new ResourceNotFoundException("Desk not found with id: " + deskId));
        return DeskMapper.mapToDeskDTO(desk);
    }

    @Override
    public DeskDTO createDesk(DeskDTO deskDTO) {
        Desk desk = DeskMapper.mapToDesk(deskDTO);
        Desk savedDesk = deskRepository.save(desk);
        return DeskMapper.mapToDeskDTO(savedDesk);
    }

    @Override
    public DeskDTO updateDesk(Long deskId, DeskDTO updatedDeskDTO) {
        Desk desk = deskRepository.findById(deskId)
                .orElseThrow(() -> new ResourceNotFoundException("Desk not found with id: " + deskId));
        desk.setDeskNo(updatedDeskDTO.getDeskNo());
        desk.setRoom(updatedDeskDTO.getRoom());
        desk.setStatus(updatedDeskDTO.getStatus());
        Desk updatedDesk = deskRepository.save(desk);
        return DeskMapper.mapToDeskDTO(updatedDesk);
    }

    @Override
    public void deleteDesk(Long deskId) {
        Desk desk = deskRepository.findById(deskId)
                .orElseThrow(() -> new ResourceNotFoundException("Desk not found with id: " + deskId));
        deskRepository.delete(desk);
    }
}