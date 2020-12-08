package com.spring.club.clubsystem.controller;

import com.spring.club.clubsystem.entity.Student;
import com.spring.club.clubsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Student> getAllStudent() {
        return studentService.getAllStudent();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public List<Student> getStudentID(@PathVariable final int id) {
        return studentService.getStudentInfo(id);
    }

    @RequestMapping(value= "/", method = RequestMethod.POST)
    public void addStudent(@RequestBody Student req) {
        studentService.addStudentInfo(req);
    }

    @RequestMapping(value= "/edit_info/{id}", method = RequestMethod.PATCH)
    public void editStudentInfo(@RequestBody Student req, @PathVariable final int id) {
        studentService.editStudentInfo(req, id);
    }
}
