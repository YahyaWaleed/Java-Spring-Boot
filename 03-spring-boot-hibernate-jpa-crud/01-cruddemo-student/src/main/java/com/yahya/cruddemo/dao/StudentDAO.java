package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    // Create operation
    void save(Student theStudent);

    // Read operation
    Student findByID(Integer id);

    // Read  operation (more than one record)
    List<Student> findAll();

    List<Student> findByLastName(String lastName);

    // Update operation
    void update(Student theStudent);

    // Delete operation
    void delete(Integer id);

    int deleteAll();

}
