package com.botscrew.assignment.service;

import com.botscrew.assignment.dao.repository.DepartmentStatisticRepository;
import com.botscrew.assignment.dto.DepartmentStatisticDTO;
import com.botscrew.assignment.entities.DepartmentStatistic;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class DepartmentStatisticService {

    private final DepartmentStatisticRepository departmentStatisticRepository;

    public DepartmentStatisticService(DepartmentStatisticRepository departmentStatisticRepository) {
        this.departmentStatisticRepository = departmentStatisticRepository;
    }

    public String getHeadOfDepartment(long departmentId) {
        return departmentStatisticRepository.findById(departmentId)
                .map(DepartmentStatistic::getDepartmentDean)
                .orElse("");
    }

    public BigDecimal getDepartmentAverageSalary(long departmentId) {
        return departmentStatisticRepository.findById(departmentId)
                .map(DepartmentStatistic::getAverageSalary)
                .orElse(BigDecimal.ZERO);
    }

    public DepartmentStatisticDTO getDepartmentStatistic(long departmentId) {
        return departmentStatisticRepository.findById(departmentId)
                .map(this::convertToDepartmentStatisticDTO)
                .orElseGet(this::getEmptyDTO);
    }

    private DepartmentStatisticDTO getEmptyDTO() {
        return new DepartmentStatisticDTO(0, 0, 0);
    }

    private DepartmentStatisticDTO convertToDepartmentStatisticDTO(DepartmentStatistic statistic) {
        return new DepartmentStatisticDTO(statistic.getAssistanceAmount(), statistic.getAssociateProfessorsAmount(),
                statistic.getProfessorsAmount());
    }
}
