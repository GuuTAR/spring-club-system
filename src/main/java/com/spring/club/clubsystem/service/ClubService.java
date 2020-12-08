package com.spring.club.clubsystem.service;

import com.spring.club.clubsystem.entity.Club;
import com.spring.club.clubsystem.repository.ClubRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {

    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getAllClubInfo() {
        return clubRepository.findAll();
    }

    public List<Club> getClubInfo(int id) {
        return clubRepository.findById(id);
    }

    public void addClub(Club club) {
        clubRepository.save(club);
    }

    public void editClubInfo(Club club, int id) {
        Club clubToUpdate = clubRepository.getOne(id);
        clubToUpdate.setDescription(club.getDescription());

        //Can't set max capacity lower than current capacity
        clubToUpdate.setCapacity(Math.max(clubToUpdate.getStudents().size(), club.getCapacity()));

        clubRepository.save(clubToUpdate);
    }
}
