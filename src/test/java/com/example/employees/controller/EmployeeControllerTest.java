package com.example.employees.controller;

import com.example.employees.dto.EmployeeDTO;
import com.example.employees.enums.GenderType;
import com.example.employees.service.EmployeeServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeServiceImp service;

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(null, "Maria", "Guadalupe", "Garcia", "Rodriguez", 23, GenderType.FEMALE, LocalDate.parse("10-09-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Developer");

        List<EmployeeDTO> employees = List.of(employeeDTO);

        given(service.findAllEmployees()).willReturn(employees);

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].firstName", is(employeeDTO.firstName())));
    }

    @Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray2() throws Exception {
        EmployeeDTO employeeDTO = new EmployeeDTO(null, "Maria", "Guadalupe", "Garcia", "Rodriguez", 23, GenderType.FEMALE, LocalDate.parse("10-09-1996", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Developer");
        EmployeeDTO employeeDTO1 = new EmployeeDTO(null, "Carlos", "", "Martinez", "Ramos", 28, GenderType.FEMALE, LocalDate.parse("11-02-1980", DateTimeFormatter.ofPattern("dd-MM-yyyy")), "Accountant");

        List<EmployeeDTO> employees = List.of(employeeDTO, employeeDTO1);

        given(service.findAllEmployees()).willReturn(employees);

        mockMvc.perform(get("/employees")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));
    }

    @Test
    public void givenEmployees_whenSaveEmployees_thenReturnCreatedStatus () throws Exception {
        String employees = """
                [
                    {
                      "firstName": "Juan",
                      "secondName": "Pablo",
                      "firstLastName": "González",
                      "secondLastName": "Fernández",
                      "age": 38,
                      "gender": "MALE",
                      "birthDate": "15-07-1985",
                      "job": "Ingeniero de Software"
                    }
                ]
                """;

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employees))
                .andExpect(status().isCreated());

    }

    @Test
    public void givenEmployees_whenSaveEmployees_thenReturnBadRequestException () throws Exception {
        String employees = """
                [
                    {
                      "firstName": "Juan",
                      "secondName": "Pablo",
                      "firstLastName": "González",
                      "secondLastName": "Fernández",
                      "age": 38,
                      "gender": "MALE",
                      "birthDate": "1985-07-15",
                      "job": "Ingeniero de Software"
                      "job": "Ingeniero de Software"
                    }
                ]
                """;

        mockMvc.perform(post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(employees))
                .andExpect(status().isBadRequest());

    }
}
