package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.StudentDTO;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers(){
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students are successfully retrieved",studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getParents(){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Parent","Returned")
                .body(new ResponseWrapper(
                true,
                "Parents are successfully retrieved",HttpStatus.OK.value(),
                studentService.findAll()));
    }
}
