package com.botscrew.assignment.entities;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity()
@Table(name = "DEPARTMENT_STATISTIC")
@Immutable
public class DepartmentStatistic {

    @Id
    @Column(name = "DEPARTMENT_ID")
    private long departmentId;
    @Column(name = "DEPARTMENT_DESCRIPTION")
    private String departmentDescription;
    @Column(name = "DEPARTMENT_DEAN")
    private String departmentDean;
    @Column(name = "ASSISTANT_AMOUNT")
    private int assistanceAmount;
    @Column(name = "ASSOCIATE_PROFESSORS_AMOUNT")
    private int associateProfessorsAmount;
    @Column(name = "PROFESSORS_AMOUNT")
    private int professorsAmount;
    @Column(name = "AVERAGE_SALARY")
    private BigDecimal averageSalary;

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartmentDean() {
        return departmentDean;
    }

    public void setDepartmentDean(String departmentDean) {
        this.departmentDean = departmentDean;
    }

    public int getAssistanceAmount() {
        return assistanceAmount;
    }

    public void setAssistanceAmount(int assistanceAmount) {
        this.assistanceAmount = assistanceAmount;
    }

    public int getAssociateProfessorsAmount() {
        return associateProfessorsAmount;
    }

    public void setAssociateProfessorsAmount(int associateProfessorsAmount) {
        this.associateProfessorsAmount = associateProfessorsAmount;
    }

    public int getProfessorsAmount() {
        return professorsAmount;
    }

    public void setProfessorsAmount(int professorsAmount) {
        this.professorsAmount = professorsAmount;
    }

    public BigDecimal getAverageSalary() {
        return averageSalary;
    }

    public void setAverageSalary(BigDecimal averageSalary) {
        this.averageSalary = averageSalary;
    }
}
