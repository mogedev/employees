package com.example.employees.model;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private String age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthDate;
    private String position;

    public static EmployeeDTO modelToEmployeeDTO(Employee employee) {
         return new EmployeeDTO(
                 employee.getId(),
                 employee.getFirstName(),
                 employee.getSecondName(),
                 employee.getFirstLastName(),
                 employee.getSecondLastName(),
                 employee.getAge(),
                 employee.getGender(),
                 employee.getBirthDate(),
                 employee.getPosition()
         );
    }
}
