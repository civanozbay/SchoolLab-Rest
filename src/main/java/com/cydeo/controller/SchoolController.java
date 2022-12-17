package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;

    public SchoolController(TeacherService teacherService, StudentService studentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
    }
    //write a method/endpoint for teachers and return as a list of teachers

    @GetMapping("/teachers")
    public List<TeacherDTO> allTeachers(){
        List<TeacherDTO> teacherDTOS = teacherService.findAll();

        return teacherDTOS;
    }

    /*
        create a endpoint for students, where json includes
        "Students are successfully retrieved." message
        code: 200
        success:true
        and student data
        8MIN
     */

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved",studentService.findAll()));
    }


}
