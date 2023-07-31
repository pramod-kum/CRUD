package com.example.crud.controller;

import com.example.crud.model.Students;
import com.example.crud.services.StudentsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentsController {
    @Autowired
    private StudentsServices studentsServices;

    @PostMapping(value = "/addStudent")
    public String addStudent(@RequestBody Students students){
       return studentsServices.saveStudent(students);
    }
    @GetMapping(value = "/getAllStudent")
    public List<Students> getAllStudent(){
        return studentsServices.getAllStudent();
    }
    @GetMapping(value = "/getStudentById/{studentId}")
    public Optional<Students> getStudentById(@PathVariable Integer studentId){
        return studentsServices.getStudentById(studentId);
    }
    @PutMapping(value = "/updateStudentById")
    public String updateStudentById(@RequestBody Students students){
        return studentsServices.updateStudentById(students);
    }
    @DeleteMapping(value = "/deleteStudentById/{studentId}")
    public String deleteStudentById(@PathVariable Integer studentId){

            return studentsServices.deleteStudentById(studentId);

    }
}
