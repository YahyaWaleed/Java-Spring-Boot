package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Course;
import com.yahya.cruddemo.entity.Instructor;
import com.yahya.cruddemo.entity.InstructorDetail;

import java.util.List;

public interface AppDao {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int id) ;

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesById(int id);

    void updateInstructor(Instructor instructor);

    void updateCourse(Course course);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course course);

    Course findCourseAndReviewByCourseId(int id);
}
