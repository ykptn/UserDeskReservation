package com.yasarbilgi.UserDeskReservation.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeskDTO {
    private Long id;
    private String deskNo;
    private String room;
    private Boolean status;
}