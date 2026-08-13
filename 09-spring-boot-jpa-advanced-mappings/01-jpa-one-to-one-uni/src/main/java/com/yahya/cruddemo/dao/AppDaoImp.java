package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

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

        // delete instructor
        entityManager.remove(tempInstructor);
    }


}
