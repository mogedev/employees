package com.example.employees.dto;

import com.example.employees.enums.GenderType;
import com.example.employees.model.Employee;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record EmployeeDTO(
        @JsonProperty(namespace = "id", access = JsonProperty.Access.READ_ONLY)
        Long id,

        @NotNull(message = "firstName is required")
        @NotEmpty(message = "firstName can't be empty")
        @NotBlank(message = "firstName can't be blank")
        @Size(min = 3, max = 20, message = "firstName should be between 3 and 20 characters")
        String firstName,

        @Size(max = 20, message = "secondName should be between 3 and 20 characters")
        String secondName,

        @NotNull(message = "firstLastName is required")
        @NotEmpty(message = "firstLastName can't be empty")
        @NotBlank(message = "firstLastName can't be blank")
        @Size(min = 3, max = 20, message = "firstLastName should be between 3 and 20 characters")
        String firstLastName,

        @NotNull(message = "secondLastName is required")
        @NotEmpty(message = "secondLastName can't be empty")
        @NotBlank(message = "secondLastName can't be blank")
        @Size(min = 3, max = 20, message = "secondLastName should be between 3 and 20 characters")
        String secondLastName,

        @NotNull(message = "age is required")
        @Min(value = 18, message = "Age should not be less than 18")
        @Max(value = 99, message = "Age should not be greater than 99")
        Integer age,

        @NotNull(message = "gender is required")
        GenderType gender,

        @NotNull(message = "birthDate is required")
        @JsonFormat(pattern = "dd-MM-yyyy")
        LocalDate birthDate,

        @NotNull(message = "secondLastName is required")
        @NotEmpty(message = "secondLastName can't be empty")
        @NotBlank(message = "secondLastName can't be blank")
        @Size(min = 3, max = 50, message = "Job should be between 3 and 50 characters")
        String job

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
                        .job(employeeDTO.job())
                        .build();
        }
}
