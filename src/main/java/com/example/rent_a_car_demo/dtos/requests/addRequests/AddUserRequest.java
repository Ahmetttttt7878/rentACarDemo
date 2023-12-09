package com.example.rent_a_car_demo.dtos.requests.addRequests;

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
public class AddUserRequest {
    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private String email;
    @NotBlank(message ="Telefon  boş olmamalı")
    @Size(min = 3,max = 20,message ="Telefon  3 ile 20 hane arasında olmalı")

    private String phone;

    private String gender;

    private Date birthDate;
}
