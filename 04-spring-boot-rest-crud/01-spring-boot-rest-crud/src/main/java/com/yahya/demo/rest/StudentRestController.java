package com.yahya.demo.rest;

import com.yahya.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api") // gives the root URL
public class StudentRestController {

    List<Student> studentList = new ArrayList<>();
    @PostConstruct
    public List<Student> loadStudents() {

        // fill in the array
        studentList.add(new Student("Yahya","Waleed"));
        studentList.add(new Student("Ahmed", "Omar"));
        studentList.add(new Student("Hamo", "Bika"));

        // return POJO array that will be converted to JSON by SPRING REST & Jackson
        return studentList;
    }

    // endpoint that gets the full list of students
    @GetMapping("/student")
    public List<Student> getStudents() {
      return studentList;

    }

    // endpoint that gets a student with a specefic ID
    @GetMapping("/student/{studentID}")
    public Student getStudent(@PathVariable int studentID /*@PathVariable links the studentID to {studentID}*/) {

        if (studentID > studentList.size() || studentID < 0) {
            throw new StudentNotFoundException("Student ID not found : " + studentID);
        }

        return studentList.get(studentID);
    }

}

