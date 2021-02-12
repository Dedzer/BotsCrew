package com.botscrew.assignment.dao.repository;

import com.botscrew.assignment.entities.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query("from Employee where lower(firstName) like %:template% or lower(lastName) like %:template%")
    List<Employee> findEmployeesByNameTemplate(String template);

}
