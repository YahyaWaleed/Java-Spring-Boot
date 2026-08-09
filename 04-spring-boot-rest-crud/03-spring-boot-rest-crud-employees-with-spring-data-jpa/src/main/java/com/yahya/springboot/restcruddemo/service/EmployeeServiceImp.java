package com.yahya.springboot.restcruddemo.service;

import com.yahya.springboot.restcruddemo.dao.EmployeeRepository;
import com.yahya.springboot.restcruddemo.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImp implements EmployeeService{

    private EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository theEmployeeRepository) {
        employeeRepository = theEmployeeRepository;
    }


    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int employeeId) {
        Optional<Employee> /*to avoid null pointer exception*/ result = employeeRepository.findById(employeeId);
        Employee theEmployee = null;
        if (result.isPresent()) {
            theEmployee = result.get(); // get actual value from wrapper (box) : Optional
        } else {
            throw new RuntimeException("Employee ID " + employeeId + "not found");
        }
        return theEmployee;
    }

    // @Transactional
    @Override
    public Employee save(Employee theEmployee) {
        return employeeRepository.save(theEmployee);
    }

    // @Transactional
    @Override
    public void deleteById(int employeeId) {

    }
}
