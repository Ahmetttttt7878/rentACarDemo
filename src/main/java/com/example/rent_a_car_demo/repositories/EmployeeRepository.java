package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse;
import com.example.rent_a_car_demo.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByPhone(String phone);

    List<Employee> findByGender(String gender);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName, e.lastName, e.username, e.password, e.email, e.role, e.phone, e.gender, e.birthDate) " +
            "FROM Employee e WHERE LOWER(e.firstName) = LOWER(:firstName)")
    List<GetEmployeeResponse> findByFirstNameIgnoreCase(String firstName);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetEmployeeResponse" +
            "(e.firstName, e.lastName, e.username, e.password, e.email, e.role, e.phone, e.gender, e.birthDate) " +
            "FROM Employee e WHERE LOWER(e.lastName) = LOWER(:lastName)")
    List<GetEmployeeResponse> findByLastNameIgnoreCase(String lastName);
}


