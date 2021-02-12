package com.botscrew.assignment.dto;

import java.util.List;

public class EmployeeSearchResultDTO {

    private final List<EmployeeDTO> employees;

    public EmployeeSearchResultDTO(List<EmployeeDTO> employees) {
        this.employees = employees;
    }

    public List<EmployeeDTO> getEmployees() {
        return employees;
    }

    @Override
    public String toString() {
        return employees.toString();
    }
}
