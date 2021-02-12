package com.botscrew.assignment.service;

import com.botscrew.assignment.dao.repository.DepartmentRepository;
import com.botscrew.assignment.entities.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public int getDepartmentEmployeesCount(long departmentId) {
        return departmentRepository.findById(departmentId)
                .map(Department::getEmployees)
                .map(List::size)
                .orElse(0);
    }

    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }
}
