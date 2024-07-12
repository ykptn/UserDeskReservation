package com.yasarbilgi.UserDeskReservation.Repository;

import com.yasarbilgi.UserDeskReservation.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmail(String email);
}