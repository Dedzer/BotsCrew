package com.botscrew.assignment.service;

import com.botscrew.assignment.dao.repository.EmployeeRepository;
import com.botscrew.assignment.dto.EmployeeDTO;
import com.botscrew.assignment.dto.EmployeeSearchResultDTO;
import com.botscrew.assignment.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeSearchResultDTO findEmployeesByTemplate(String template) {
        return new EmployeeSearchResultDTO(employeeRepository.findEmployeesByNameTemplate(template)
                .stream()
                .map(this::convertTOEmployeeDTO)
                .collect(Collectors.toList()));
    }

    private EmployeeDTO convertTOEmployeeDTO(Employee employee) {
        return new EmployeeDTO(employee.getFirstName().concat(" ").concat(employee.getLastName()));
    }
}
