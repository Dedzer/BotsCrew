package com.botscrew.assignment.controller;

import com.botscrew.assignment.dto.EmployeeSearchResultDTO;
import com.botscrew.assignment.enums.DepartmentEnum;
import com.botscrew.assignment.service.DepartmentService;
import com.botscrew.assignment.service.DepartmentStatisticService;
import com.botscrew.assignment.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class EntryController implements CommandLineRunner {

    private final EmployeeService employeeService;
    private final DepartmentService departmentService;
    private final DepartmentStatisticService departmentStatisticService;
    private final Scanner scanner = new Scanner(System.in);

    public EntryController(EmployeeService employeeService, DepartmentService departmentService,
                           DepartmentStatisticService departmentStatisticService) {
        this.employeeService = employeeService;
        this.departmentService = departmentService;
        this.departmentStatisticService = departmentStatisticService;
    }

    @Override
    public void run(String... args) throws Exception {
        buildCommandsMenu();
        handleCommand(getChosenCommand());
        System.out.println("Do you want to continue ?");
        if (scanner.nextBoolean()) {
            run();
        }
    }

    private void handleCommand(int command) {
        switch (command) {
            case 1:
                handleFirstCommand();
                break;
            case 2:
                handleSecondCommand();
                break;
            case 3:
                handleThirdCommand();
                break;
            case 4:
                handleForthCommand();
                break;
            case 5:
                handleFifthCommand();
        }
    }

    private void handleFirstCommand() {
        buildDepartmentMenu();
        DepartmentEnum department = getChosenDepartment();
        System.out.println("Head of " + department.getDescription() + " is "
                + departmentStatisticService.getHeadOfDepartment(department.getDatabaseKey()));
    }

    private void handleSecondCommand() {
        buildDepartmentMenu();
        DepartmentEnum departmentEnum = getChosenDepartment();
        System.out.println(departmentStatisticService.getDepartmentStatistic(departmentEnum.getDatabaseKey()).toString());
    }

    private void handleThirdCommand() {
        buildDepartmentMenu();
        DepartmentEnum departmentEnum = getChosenDepartment();
        System.out.println("The average salary of " + departmentEnum.getDescription() + " is " +
                departmentStatisticService.getDepartmentAverageSalary(departmentEnum.getDatabaseKey()) + " USD");
    }

    private void handleForthCommand() {
        buildDepartmentMenu();
        DepartmentEnum departmentEnum = getChosenDepartment();
        System.out.println(departmentService.getDepartmentEmployeesCount(departmentEnum.getDatabaseKey()));
    }

    private void handleFifthCommand() {
        EmployeeSearchResultDTO employeeSearchResultDTO = employeeService.findEmployeesByTemplate(getTemplate());
        if (employeeSearchResultDTO.getEmployees().isEmpty()) {
            System.out.println("No employee found");
        }
        System.out.println(employeeSearchResultDTO.getEmployees().toString());
    }

    private String getTemplate() {
        System.out.println("Please enter the template");
        return scanner.nextLine();
    }

    private void buildDepartmentMenu() {
        System.out.println("Please choose department: ");
        for (DepartmentEnum department : DepartmentEnum.values()) {
            System.out.println(department.getDatabaseKey() + ". " + department.getDescription());
        }
    }

    private DepartmentEnum getChosenDepartment() {
        while (true) {
            long departmentId = scanner.nextLong();
            DepartmentEnum department = DepartmentEnum.fromDatabaseKey(departmentId);
            if (department != null) {
                return department;
            }
            System.out.println("No department selected");
        }
    }

    private void buildCommandsMenu() {
        System.out.println("Please choose your command: ");
        System.out.println("1. Who is head of department ?");
        System.out.println("2. Show department statistics");
        System.out.println("3. Show the average salary for the department");
        System.out.println("4. Show count of employee for department");
        System.out.println("5. Search employees");
    }

    private int getChosenCommand() {
        while (true) {
            int command = scanner.nextInt();
            if (command > 0 && command < 6) {
                return command;
            }
            System.out.println("No command selected");
        }
    }
}
