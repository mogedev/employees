package com.example.employees.dto;

import com.example.employees.enums.Gender;
import com.example.employees.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.boot.jackson.JsonComponent;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmployeeDTO(
        @JsonProperty(namespace = "id", access = JsonProperty.Access.READ_ONLY)
        Long id,
        @NotNull
        @NotEmpty
        @NotBlank
        String firstName,

        String secondName,

        @NotNull
        @NotEmpty
        @NotBlank
        String firstLastName,

        @NotNull
        @NotEmpty
        @NotBlank
        String secondLastName,

        @NotNull
        @NotBlank
        @NotEmpty
        String age,

        @NotNull
        Gender gender,

        @NotNull
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate,

        @NotNull
        @NotBlank
        @NotEmpty
        String position

) {
        public static Employee dtoToEmployeeModel(EmployeeDTO employeeDTO) {
                return Employee.builder()
                        .firstName(employeeDTO.firstName())
                        .secondName(employeeDTO.secondName())
                        .firstLastName(employeeDTO.firstLastName())
                        .secondLastName(employeeDTO.secondLastName())
                        .age(employeeDTO.age())
                        .gender(employeeDTO.gender())
                        .birthDate(employeeDTO.birthDate())
                        .position(employeeDTO.position())
                        .build();
        }
}
