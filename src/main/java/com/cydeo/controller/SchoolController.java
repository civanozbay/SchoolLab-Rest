package com.cydeo.controller;

import com.cydeo.client.WeatherClient;
import com.cydeo.dto.*;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class SchoolController {
    private final TeacherService teacherService;
    private final StudentService studentService;
    private final WeatherClient weatherClient;
    private final ParentService parentService;
    private final AddressService addressService;



    public SchoolController(TeacherService teacherService, StudentService studentService, WeatherClient weatherClient, ParentService parentService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.weatherClient = weatherClient;
        this.parentService = parentService;
        this.addressService = addressService;
    }

    @GetMapping("/teachers")
    public List<TeacherDTO> getTeachers(){
        return teacherService.findAll();
    }

    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> getStudents(){
        return ResponseEntity
                .ok(new ResponseWrapper
                        ("Students are successfully retrieved"
                                ,studentService.findAll()));
    }

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> getParents(){

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Parent","Returned")
                .body(new ResponseWrapper(
                true,
                "Parents are successfully retrieved",HttpStatus.OK.value(),
                parentService.findAll()));
    }

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getUserAddress(@PathVariable("id") Long id) throws Exception {
        AddressDTO address = addressService.findById(id);
        CityDTO cityTemperature = weatherClient.getCityInfo(address.getCity());
        address.setCurrentTemperature(cityTemperature.getCurrent().getTemperature());

        return ResponseEntity.
                ok(new ResponseWrapper("Address "+id+"is successfully retrieved"
                ,addressService.findById(id)));
    }

    @PutMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> updateUserAddress(@PathVariable("id") Long id,@RequestBody AddressDTO addressDTO) throws Exception {
        addressDTO.setId(id);
        return ResponseEntity
                .ok(new ResponseWrapper("Address of "+id+" is updated"
                        ,addressService.update(addressDTO)));
    }

}

