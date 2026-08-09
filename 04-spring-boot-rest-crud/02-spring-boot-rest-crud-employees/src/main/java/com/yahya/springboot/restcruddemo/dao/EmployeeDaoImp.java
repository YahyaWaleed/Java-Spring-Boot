package com.yahya.springboot.restcruddemo.dao;

import com.yahya.springboot.restcruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImp  implements  EmployeeDAO{

    private EntityManager entityManager; //object that allows communication with an entity

    @Autowired
    public EmployeeDaoImp(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // create query
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee " , Employee.class);

        // execute query and get result
        List<Employee> employees = theQuery.getResultList();

        // return list
        return employees;
    }

    @Override
    public Employee findById(int employeeId) {
        //get employee
        Employee employee = entityManager.find(Employee.class , employeeId); // find an entity(object stored in db) by its id
        //return employee
        return employee;
    }

    @Override
    public Employee save(Employee theEmployee) {
        Employee dbEmployee = entityManager.merge(theEmployee);  // not sure ?! (new row or update)
        return dbEmployee;
    }

    @Override
    public void deleteById(int employeeId) {
        Employee theEmployee = entityManager.find(Employee.class , employeeId);

        entityManager.remove(theEmployee);
    }
}
