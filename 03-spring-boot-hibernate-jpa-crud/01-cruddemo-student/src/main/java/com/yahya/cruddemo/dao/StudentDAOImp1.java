package com.yahya.cruddemo.dao;

import com.yahya.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        entityManager.persist(theStudent); // persist --> saves object into database
    }

    @Override
    public Student findByID(Integer id) {
       return entityManager.find(Student.class,id); // find(ClassName.class, primary key) --> looks for object in the table with the specific primary key
    }

    @Override
    public List<Student> findAll() {
        //create query
        TypedQuery<Student> /*this query will return Student Objects*/ myQuery = entityManager.createQuery("From Student order by firstName", Student.class);

        // return query results
        return myQuery.getResultList(); //returns result as a list

    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        //create query
        TypedQuery<Student> myQuery = entityManager.createQuery("From Student where lastName=:theData", Student.class);

        // set parameter
        myQuery.setParameter("theData", theLastName);

        // return query results
        return myQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        // read student
        Student theStudent = entityManager.find(Student.class, id);

        // delete student
        entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int  numRowsDeleted = entityManager.createQuery("delete from Student ").executeUpdate();
        return numRowsDeleted;
    }

}
