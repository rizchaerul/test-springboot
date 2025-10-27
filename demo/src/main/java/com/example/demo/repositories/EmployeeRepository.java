package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
    @Query(value = "SELECT Id, FullName FROM Employee2", nativeQuery = true)
    List<Employee> getEmployeesWithCustomQUery();
}
