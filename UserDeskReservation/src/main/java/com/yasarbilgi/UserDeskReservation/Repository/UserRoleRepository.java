package com.yasarbilgi.UserDeskReservation.Repository;

import com.yasarbilgi.UserDeskReservation.Entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}