package com.yahya.springboot.restcruddemo.service;

import com.yahya.springboot.restcruddemo.dao.EmployeeDAO;
import com.yahya.springboot.restcruddemo.dao.EmployeeDaoImp;
import com.yahya.springboot.restcruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeDAO employeeDAO;

    public EmployeeServiceImp(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }


    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        return employeeDAO.findById(employeeId);
    }

    @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeDAO.save(theEmployee);
    }

    @Transactional
    @Override
    public void deleteById(int employeeId) {

    }
}
