package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.Employee;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequest  {
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    @NotBlank(message = "email boş olamaz")
    @Size (min =3 , max = 30, message = "kullanıcı adı 3 ile 30 hane arasında olmalı")
    private String email;
    private String role;
    private String phone;
    private String gender;
    private Date birthDate;
}
