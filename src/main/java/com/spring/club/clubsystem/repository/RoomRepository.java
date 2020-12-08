package com.spring.club.clubsystem.repository;

import com.spring.club.clubsystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findByLevel(int level);
    List<Room> findById(int id);
}
