package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddEmployeeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateEmployeeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetEmployeeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse;
import com.example.rent_a_car_demo.services.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/getall")
    public List<GetEmployeeListResponse> getEmployeeList(){
        return this.employeeService.getEmployeeList();}
    @GetMapping("/{id}")
    public GetEmployeeResponse getEmployeeById(@PathVariable int id){
        return this.employeeService.getEmployeeById(id);}
    @PostMapping("/create")
    public String createEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest){
        return this.employeeService.createEmployee(addEmployeeRequest);
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) throws Exception {
        return this.employeeService.updateEmployee(updateEmployeeRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) throws Exception {
        return this.employeeService.deleteByEmployee(id);
    }

    @GetMapping("/phone")
    public List<GetEmployeeResponse> findByPhone(@RequestParam String phone){
        return this.employeeService.findByPhone(phone);
    }
    @GetMapping("/gender")
    public List<GetEmployeeResponse>findByGender(@RequestParam String gender){
        return this.employeeService.findByGender(gender);
    }
    @GetMapping("/firstName")
    public List<GetEmployeeResponse>findByFirstNameIgnoreCase(@RequestParam String firstName){
        return this.employeeService.findByFirstNameIgnoreCase(firstName);
    }
    @GetMapping("/lastName")
    public List<GetEmployeeResponse>findByLastNameIgnoreCase(@RequestParam String lastName){
        return this.employeeService.findByLastNameIgnoreCase(lastName);
    }


}

