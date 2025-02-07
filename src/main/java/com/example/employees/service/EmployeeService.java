package com.example.employees.service;

import com.example.employees.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDTO> findAllEmployees();
    void saveEmployee(List<EmployeeDTO> employees);
    void deleteEmployee(Long id);
    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);
}
