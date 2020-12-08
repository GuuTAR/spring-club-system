package com.spring.club.clubsystem.controller;

import com.spring.club.clubsystem.entity.Club;
import com.spring.club.clubsystem.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/club")
public class ClubController {

    @Autowired
    private ClubService clubService;

    @RequestMapping(value="/",method = RequestMethod.GET)
    public List<Club> getAllClubInfo() {
        return clubService.getAllClubInfo();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.GET)
    public List<Club> getClubInfo(@PathVariable final int id) {
        return clubService.getClubInfo(id);
    }

    @RequestMapping(value="/", method = RequestMethod.POST)
    public void addClub(@RequestBody Club club) {
        clubService.addClub(club);
    }

    @RequestMapping(value="/{id}", method = RequestMethod.PATCH)
    public void editClubInfo(@RequestBody Club club, @PathVariable final int id) {
        clubService.editClubInfo(club, id);
    }
}
