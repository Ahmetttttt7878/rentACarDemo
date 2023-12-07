package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddEmployeeRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateEmployeeRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetEmployeeListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.repositories.EmployeeRepository;
import com.example.rent_a_car_demo.services.abstracts.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {

    private EmployeeRepository employeeRepository;



        public List<GetEmployeeListResponse> getEmployeeList () {
            List<Employee> employeeList = employeeRepository.findAll();
            List<GetEmployeeListResponse> getEmployeeListResponse = new ArrayList<>();

            for (Employee employee : employeeList) {
                GetEmployeeListResponse response = new GetEmployeeListResponse();
                response.setFirstName(employee.getFirstName());
                response.setUsername(employee.getUsername());
                response.setLastName(employee.getLastName());
                getEmployeeListResponse.add(response);
            }
            return getEmployeeListResponse;

        }

        public GetEmployeeResponse getEmployeeById (Integer id){
            Employee employee = employeeRepository.findById(id).orElseThrow();
            GetEmployeeResponse dto = new GetEmployeeResponse();
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());
            dto.setUsername(employee.getUsername());

            return dto;
        }
        @Override
        public String createEmployee (AddEmployeeRequest addEmployeeRequest){{
                Employee employee = new Employee();
                employee.setFirstName(addEmployeeRequest.getFirstName());
                employee.setLastName(addEmployeeRequest.getLastName());
                employee.setUsername(addEmployeeRequest.getUsername());
                employee.setPassword(addEmployeeRequest.getPassword());
                employee.setEmail(addEmployeeRequest.getEmail());
                employee.setRole(addEmployeeRequest.getRole());
                employee.setPhone(addEmployeeRequest.getPhone());
                employee.setGender(addEmployeeRequest.getGender());
                employee.setBirthDate(addEmployeeRequest.getBirthDate());
                employeeRepository.save(employee);
                return "Transaction Successful ";
            }

        }

    @Override
    public String updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = employeeRepository.findById(updateEmployeeRequest.getId()).orElseThrow();

        employee.setFirstName(updateEmployeeRequest.getFirstName());
        employee.setLastName(updateEmployeeRequest.getLastName());
        employee.setUsername(updateEmployeeRequest.getUsername());
        employee.setPassword(updateEmployeeRequest.getPassword());
        employee.setEmail(updateEmployeeRequest.getEmail());

        this.employeeRepository.save(employee);
        return "Transaction Successful ";
    }

    @Override
    public String deleteByEmployee(int id) throws Exception {
        this.employeeRepository.findById(id).orElseThrow();
        this.employeeRepository.deleteById(id);
        return "Deletion successful";
    }


    @Override
    public List<GetEmployeeResponse> findByPhone(String phone) {
        List<Employee> employees = employeeRepository.findByPhone(phone);
        List<GetEmployeeResponse> response = new ArrayList<>();

        for (Employee employee : employees) {
            GetEmployeeResponse getResponse = new GetEmployeeResponse();
            getResponse.setFirstName(employee.getFirstName());
            getResponse.setLastName(employee.getLastName());
            getResponse.setUsername(employee.getUsername());
            getResponse.setPassword(employee.getPassword());
            getResponse.setEmail(employee.getEmail());
            getResponse.setRole(employee.getRole());
            getResponse.setPhone(employee.getPhone());
            getResponse.setGender(employee.getGender());
            getResponse.setBirthDate(employee.getBirthDate());
            response.add(getResponse);

        }
        return response;
    }

    @Override
    public List<GetEmployeeResponse> findByGender(String gender) {
        List<Employee> employees = employeeRepository.findByGender(gender);
        List<GetEmployeeResponse> response = new ArrayList<>();

        for (Employee employee : employees) {
            GetEmployeeResponse getResponse = new GetEmployeeResponse();
            getResponse.setFirstName(employee.getFirstName());
            getResponse.setLastName(employee.getLastName());
            getResponse.setUsername(employee.getUsername());
            getResponse.setPassword(employee.getPassword());
            getResponse.setEmail(employee.getEmail());
            getResponse.setRole(employee.getRole());
            getResponse.setPhone(employee.getPhone());
            getResponse.setGender(employee.getGender());
            getResponse.setBirthDate(employee.getBirthDate());
            response.add(getResponse);

        }
        return response;
    }

    @Override
    public List<GetEmployeeResponse> findByFirstNameIgnoreCase(String firstName) {
        return this.employeeRepository.findByFirstNameIgnoreCase(firstName);
    }

    @Override
    public List<GetEmployeeResponse> findByLastNameIgnoreCase(String lastName) {
        return this.employeeRepository.findByLastNameIgnoreCase(lastName);
    }
}

