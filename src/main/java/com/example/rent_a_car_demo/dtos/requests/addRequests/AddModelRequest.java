package com.example.rent_a_car_demo.dtos.requests.addRequests;

import com.example.rent_a_car_demo.models.Brand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddModelRequest {
    @NotBlank(message = "Model ismi boş olamaz")
    @Size(min = 3,max = 20,message="Model 3 ile 20 hane arasında olmalı")
    private String name;

    private String fuelType;

    private String enginePower;

    private Brand brand;


}
