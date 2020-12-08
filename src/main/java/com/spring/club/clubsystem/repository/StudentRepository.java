package com.spring.club.clubsystem.repository;

import com.spring.club.clubsystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findById(int id);
}
