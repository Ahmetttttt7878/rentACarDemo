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
public class AddRentalRequest {
    @NotBlank(message ="Kiralama başlangıç tarihi boş olmamalı")
    @Size(min = 3,max = 20,message="kiralamak başlangıç tarihi 3 ile 20 hane arasında olmalı")
    private Date rentalStartDate;
    private Date rentalEndDate;
    private double totalCost;
    private int carId;
    private int userId;
    private int employeeId;
}
