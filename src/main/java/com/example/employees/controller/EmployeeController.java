package com.example.employees.controller;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.service.EmployeeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/***
 * CRUD Employee Controller
 */
@RestController
@RequestMapping("/employees")
@Tag(name = "Employee API", description = "Employee API")
public class EmployeeController {
    private final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeServiceImp employeeServiceImp;

    public EmployeeController(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }

    @Operation(summary = "Get all employees")
    @ApiResponse(responseCode = "200", description = "Employees found")
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAllEmployees() {
        log.info("Employees to find");
        return ResponseEntity.ok(employeeServiceImp.findAllEmployees());
    }

    @Operation(summary = "Create new employees")
    @ApiResponse(responseCode = "201", description = "Employees created")
    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<Void> saveEmployees(@RequestBody List<@Valid EmployeeDTO> employees) {
        log.info("Employees to save: {}", employees);
        employeeServiceImp.saveEmployee(employees);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Delete employee")
    @ApiResponse(responseCode = "204", description = "Employee deleted")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        log.info("Employee to delete with id: {}", id);
        employeeServiceImp.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Update employee")
    @ApiResponse(responseCode = "200", description = "Employee updated")
    @PatchMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody @Valid EmployeeDTO employee) {
        log.info("Employee to update with id: {}, employeeUpdated: {}", id, employee);
        return ResponseEntity.ok(employeeServiceImp.updateEmployee(id, employee));
    }
}
