package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAOImp1 implements StudentDAO{

    // 1. Define Field for Entity Manager //
    @Autowired
    private EntityManager entityManager; // this objects has methods that help communication with the DB

    // 2. Inject Entity Manager Using Constructor Injection //
    public StudentDAOImp1(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // 3. Implement the save() Method //
    @Override
    @Transactional // used if the function will update the database
    // this is Create operation
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

}
