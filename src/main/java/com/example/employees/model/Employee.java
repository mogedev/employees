package com.example.employees.model;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.enums.GenderType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnTransformer;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String secondName;
    private String firstLastName;
    private String secondLastName;
    private Integer age;
    @Enumerated(EnumType.STRING)
    @ColumnTransformer(write = "?::gender_type")
    private GenderType gender;
    private LocalDate birthDate;
    private String job;

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
                 employee.getJob()
         );
    }
}
