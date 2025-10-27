package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.employee.EmployeeListItem;
import com.example.demo.repositories.EmployeeRepository;

@RestController()
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    private final EmployeeRepository repo;

    public EmployeeController(EmployeeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    ResponseEntity<List<EmployeeListItem>> getAllEmployee(
        @RequestParam(required = false, defaultValue = "1") int page,
        @RequestParam(required = false, defaultValue = "10") int pageSize
    ) {
        if (pageSize > 100) {
            throw new IllegalArgumentException("pageSize cannot be greater than 100");
        }

        var employees = repo.getEmployeesWithCustomQUery();

        return ResponseEntity.ok(new ArrayList<EmployeeListItem>());
    }
}
