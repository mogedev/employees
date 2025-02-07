package com.example.employees.service;

import com.example.employees.config.exceptions.NotFoundException;
import com.example.employees.dto.EmployeeDTO;
import com.example.employees.model.Employee;
import com.example.employees.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.example.employees.dto.EmployeeDTO.dtoToEmployeeModel;
import static com.example.employees.model.Employee.modelToEmployeeDTO;


/***
 * CRUD Employee Service
 */
@Service
public class EmployeeServiceImp implements EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeServiceImp.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImp(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    /***
     * Method to search for all employees
     * @return List of employees
     */
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();

        return employees.stream()
                .map(Employee::modelToEmployeeDTO)
                .toList();
    }

    /***
     * Method to add employee
     * @param employees
     */
    public void saveEmployee(List<EmployeeDTO> employees) {
        employees.forEach(employee -> employeeRepository.save(dtoToEmployeeModel(employee)));
        log.info("Employees saved");
    }

    /***
     * Method to delete employee
     * @param id
     */
    public void deleteEmployee(Long id) {
        employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        employeeRepository.deleteById(id);
        log.info("Employee with ID {} deleted successfully", id);
    }

    /***
     * Method to update employee
     * @param id
     * @param employeeDTO
     * @return employee
     */
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {
        employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Employee not found"));
        Employee employeeSaved = employeeRepository.save(dtoToEmployeeModel(employeeDTO));
        log.info("Employee updated successfully");
        return modelToEmployeeDTO(employeeSaved);
    }
}
