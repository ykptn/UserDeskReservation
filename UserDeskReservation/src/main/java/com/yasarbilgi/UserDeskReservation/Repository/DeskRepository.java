package com.yasarbilgi.UserDeskReservation.Repository;

import com.yasarbilgi.UserDeskReservation.Entity.Desk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeskRepository extends JpaRepository<Desk, Long> {
}

