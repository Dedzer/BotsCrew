package com.botscrew.assignment.dto;

public class EmployeeDTO {

    private final String fullName;

    public EmployeeDTO(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
