package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Course;
import com.yahya.cruddemo.entity.Instructor;
import com.yahya.cruddemo.entity.InstructorDetail;
import com.yahya.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDaoImp implements AppDao{
    // define field for entity manager
    private final EntityManager entityManager;


    // inject entity manager using constructor injection
    @Autowired
    public AppDaoImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    };

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        // find instructor first
        Instructor tempInstructor = entityManager.find(Instructor.class,id);

        // delete courses for this instructor
        List<Course> courses = tempInstructor.getCourses(); // get instructor courses
        for (Course course :  courses) {
            course.setInstructor(null);
        }

        // delete instructor
        entityManager.remove(tempInstructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        // find instructor detail first then delete him
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    public List<Course> findCoursesById(int id) {
        // create query
        TypedQuery<Course> query = entityManager.createQuery("from Course  where instructor.id= :data", Course.class);
        query.setParameter("data", id);

        // execute query
        List<Course> courses = query.getResultList();

        return courses;
    }

    @Override
    @Transactional
    public void updateInstructor(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
        return (entityManager.find(Course.class, id));
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course courseToDelete = entityManager.find(Course.class,id);
        entityManager.remove(courseToDelete);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN Fetch  c.reviews where c.id = :data", Course.class);
        query.setParameter("data", id);
        Course courseToFind = query.getSingleResult();
        return courseToFind;
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN Fetch  c.students where c.id = :data", Course.class);
        query.setParameter("data", id);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentId(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s JOIN Fetch  s.courses where s.id = :data", Student.class);
        query.setParameter("data", id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {
        entityManager.remove(entityManager.find(Student.class, id));
    }


}
