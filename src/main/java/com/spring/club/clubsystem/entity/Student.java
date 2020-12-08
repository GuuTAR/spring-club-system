package com.spring.club.clubsystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int student_reg_id;
    private String name;
    private String phone;

    @JsonIgnoreProperties("students")
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Room room;

    @JsonIgnoreProperties("students")
    @ManyToOne(
            fetch = FetchType.EAGER
    )
    private Club club;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_reg_id() {
        return student_reg_id;
    }

    public void setStudent_reg_id(int student_reg_id) {
        this.student_reg_id = student_reg_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }
}
