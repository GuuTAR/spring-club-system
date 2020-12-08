package com.spring.club.clubsystem.service;

import com.spring.club.clubsystem.entity.Room;
import com.spring.club.clubsystem.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getRoomInfo(int id) {
        return roomRepository.findById(id);
    }

    public List<Room> getAllRoomByLevel(int id) {
        return roomRepository.findByLevel(id);
    }

    public void addRoom(Room room) {
        roomRepository.save(room);
    }

    public void editRoomInfo(Room room, int id) {
        Room roomToUpdate = roomRepository.getOne(id);
        roomToUpdate.setProgram(room.getProgram());

        //Can't set max capacity lower than current capacity
        roomToUpdate.setCapacity(Math.max(roomToUpdate.getStudents().size(), room.getCapacity()));

        roomToUpdate.setLevel(room.getLevel());
        roomRepository.save(roomToUpdate);
    }
}
