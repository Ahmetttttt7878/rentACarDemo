package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddAddressRequest {
    @NotBlank(message ="Address boş olamaz")
    @Size(min = 3,max = 50,message = "Adrees 3 ile 50 hane arasında olmalı")

    private String address;

    private String country;

    private String region;

    private String city;

    private String zipCode;

    private User user;
}
