package com.spring.club.clubsystem.controller;

import com.spring.club.clubsystem.entity.Room;
import com.spring.club.clubsystem.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    private List<Room> getRoomEdit(@PathVariable final int id) {
        return roomService.getRoomInfo(id);
    }

    @RequestMapping(value="/level/{level_id}", method = RequestMethod.GET)
    private List<Room> getAllRoomByLevel(@PathVariable final int level_id) {
        return roomService.getAllRoomByLevel(level_id);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    private void addRoomInfo(@RequestBody Room room) {
        roomService.addRoom(room);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    private void editRoomInfo(@RequestBody Room room, @PathVariable final int id) {
        roomService.editRoomInfo(room, id);
    }

}
