package com.yasarbilgi.UserDeskReservation.Service;

import com.yasarbilgi.UserDeskReservation.DTO.DeskDTO;
import java.util.List;

public interface DeskService {
    DeskDTO createDesk(DeskDTO deskDTO);
    DeskDTO getDeskById(Long deskId);
    List<DeskDTO> getAllDesks();
    DeskDTO updateDesk(Long deskId, DeskDTO updatedDesk);
    void deleteDesk(Long deskId);
}