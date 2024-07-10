package com.yasarbilgi.UserDeskReservation.Mapper;

import com.yasarbilgi.UserDeskReservation.DTO.DeskDTO;
import com.yasarbilgi.UserDeskReservation.Entity.Desk;

public class DeskMapper {

    public static DeskDTO mapToDeskDTO(Desk desk) {
        return new DeskDTO(
                desk.getId(),
                desk.getDeskNo(),
                desk.getRoom(),
                desk.getStatus()
        );
    }

    public static Desk mapToDesk(DeskDTO deskDTO) {
        return new Desk(
                deskDTO.getId(),
                deskDTO.getDeskNo(),
                deskDTO.getRoom(),
                deskDTO.getStatus()
        );
    }
}

