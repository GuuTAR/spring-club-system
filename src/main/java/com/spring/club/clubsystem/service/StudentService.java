package com.spring.club.clubsystem.service;

import com.spring.club.clubsystem.entity.Room;
import com.spring.club.clubsystem.entity.Student;
import com.spring.club.clubsystem.repository.RoomRepository;
import com.spring.club.clubsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private RoomRepository roomRepository;

    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    public List<Student> getStudentInfo(int id) {
        return studentRepository.findById(id);
    }

    public void addStudentInfo(Student student) {
        System.out.println(student.getRoom().getId());
        Room roomJoined = roomRepository.getOne(student.getRoom().getId());
        // Can't add student if room is full
        if (roomJoined.getCapacity() > roomJoined.getStudents().size()) {
            studentRepository.save(student);
        }
    }

    public void editStudentInfo(Student student, int id) {
        Student studentToUpdate = studentRepository.getOne(id);
        studentToUpdate.setStudent_reg_id(student.getStudent_reg_id());
        studentToUpdate.setName(student.getName());
        studentToUpdate.setPhone(student.getPhone());
        studentToUpdate.setRoom(student.getRoom());
        studentToUpdate.setClub(student.getClub());
        studentRepository.save(studentToUpdate);
    }
}
