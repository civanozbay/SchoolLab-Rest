package com.cydeo.controller;

import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService parentService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService parentService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.parentService = parentService;
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

    /*
        create a parents endpoint where status code is 202
        additional header has "Parent","Returned"
        and following json body structure
        "Parents are successfully retrieved." message
        code: 200
        success:true
        and parents data
        7MIN
     */
        @GetMapping("/parents")
        public ResponseEntity<ResponseWrapper> readAllParents(){
            ResponseWrapper responseWrapper = new ResponseWrapper(true,
                    "Parents are successfuly retrieved",
                    HttpStatus.OK.value(), parentService.findAll());

            return ResponseEntity
                            .status(HttpStatus.ACCEPTED)
                            .header("Parent","Returned")
                            .body(responseWrapper);

        }


}
