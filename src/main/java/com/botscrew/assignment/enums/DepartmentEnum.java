package com.botscrew.assignment.enums;

public enum DepartmentEnum {
    DOaG(1, "Drilling, Oil and Gas"),
    MEaICS(2, "Metals Engineering and Industrial Computer Science"),
    MEaR(3, "Mechanical Engineering and Robotics");

    private final long databaseKey;
    private final String description;

    DepartmentEnum(long databaseKey, String description) {
        this.databaseKey = databaseKey;
        this.description = description;
    }

    public static DepartmentEnum fromDatabaseKey(long databaseKey) {
        for (DepartmentEnum department: values()) {
            if (department.getDatabaseKey() == databaseKey) {
                return department;
            }
        }
        return null;
    }

    public long getDatabaseKey() {
        return databaseKey;
    }

    public String getDescription() {
        return description;
    }

}
