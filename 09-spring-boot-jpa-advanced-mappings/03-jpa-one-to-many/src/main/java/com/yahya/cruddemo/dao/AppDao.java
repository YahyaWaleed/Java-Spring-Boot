package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Instructor;
import com.yahya.cruddemo.entity.InstructorDetail;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id) ;

    void deleteInstructorDetailById(int id);
}
