package com.example.crud.services;

import com.example.crud.model.Students;
import com.example.crud.repository.IStudents;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentsServices {
    @Autowired
    private IStudents iStudents;

    public String saveStudent(Students students) {
        iStudents.save(students);
        return "Student added successfully!!";
    }

    public List<Students> getAllStudent() {
        return iStudents.findAll();
    }

    public Optional<Students> getStudentById(Integer studentId) {
        return iStudents.findById(studentId);
    }
    @Transactional
    public String updateStudentById(Students students) {
        iStudents.updateStudent(students.getStudentId(),students.getStudentName(),students.getStudentAge()
                ,students.getStudentMobileNumber(),students.getStudentEmailId(),students.getStudentAddress());
       return "Student updated successfully!!";
    }

    public String deleteStudentById(Integer studentId) {
        if(iStudents.existsById(studentId)){
            iStudents.deleteById(studentId);
            return "Student deleted successfully!!";
        }
            return "StudentId not Exist...Sorry!!";
    }
}
