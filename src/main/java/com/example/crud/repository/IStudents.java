package com.example.crud.repository;

import com.example.crud.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudents extends JpaRepository<Students,Integer> {
    @Modifying
    @Query(value = "update students set student_Name =:studentName,student_Age=:studentAge,student_Mobile_Number=:studentMobileNumber,student_Email_Id=:studentEmailId,student_Address=:studentAddress where student_Id=:studentId", nativeQuery = true)
    void updateStudent(Integer studentId, String studentName, Integer studentAge, String studentMobileNumber, String studentEmailId, String studentAddress);
}
