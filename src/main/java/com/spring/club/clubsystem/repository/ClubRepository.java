package com.spring.club.clubsystem.repository;

import com.spring.club.clubsystem.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClubRepository extends JpaRepository<Club, Integer> {
    List<Club> findById(int id);
}
