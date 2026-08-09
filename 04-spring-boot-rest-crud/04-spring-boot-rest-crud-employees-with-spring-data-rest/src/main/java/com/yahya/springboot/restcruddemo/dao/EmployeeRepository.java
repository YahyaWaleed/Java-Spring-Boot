package com.yahya.springboot.restcruddemo.dao;

import com.yahya.springboot.restcruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "members") // changes resource path (root url) //
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // no need to write any code //
}
