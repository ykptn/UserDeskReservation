package com.yasarbilgi.UserDeskReservation.Repository;

import com.yasarbilgi.UserDeskReservation.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}

