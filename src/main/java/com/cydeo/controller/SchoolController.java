package com.cydeo.controller;

import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.TeacherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;

    public SchoolController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }
    //write a method/endpoint for teachers and return as a list of teachers

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        List<TeacherDTO> teacherDTOS = teacherService.findAll();

        return teacherDTOS;
    }
}