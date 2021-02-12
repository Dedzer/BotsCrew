package com.botscrew.assignment.dto;

public class DepartmentStatisticDTO {

    private final Integer assistance;
    private final Integer associateProfessors;
    private final Integer professors;

    public DepartmentStatisticDTO(Integer assistance, Integer associateProfessors, Integer professors) {
        this.assistance = assistance;
        this.associateProfessors = associateProfessors;
        this.professors = professors;
    }

    public Integer getAssistance() {
        return assistance;
    }

    public Integer getAssociateProfessors() {
        return associateProfessors;
    }

    public Integer getProfessors() {
        return professors;
    }

    @Override
    public String toString() {
        return "assistance - " + assistance + "\n" +
                "associate professors - " + associateProfessors + "\n" +
                "professors - " + professors;
    }
}
