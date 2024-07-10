package com.yasarbilgi.UserDeskReservation.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Desk")
public class Desk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "desk_no", nullable = false, unique = true)
    private String deskNo;

    @Column(name = "room")
    private String room;

    @Column(name = "status")
    private Boolean status;
}

