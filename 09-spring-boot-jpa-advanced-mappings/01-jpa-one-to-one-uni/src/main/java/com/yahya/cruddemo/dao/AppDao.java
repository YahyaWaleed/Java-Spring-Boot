package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Instructor;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);
}
