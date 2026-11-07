package com.company.employee_service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/home")
    public Map<String, String> home() {

        return Map.of(
            "application", "Employee Management System",
            "technology", "Java Spring Boot",
            "status", "Running"
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {

        return Map.of(
            "status", "UP"
        );
    }

    @GetMapping("/employees")
    public Map<String, Object> employees() {

        return Map.of(
            "employeeId", 101,
            "employeeName", "John",
            "department", "DevOps",
            "designation", "DevOps Engineer"
        );
    }
}
