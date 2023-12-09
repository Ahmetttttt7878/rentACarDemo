package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddCarRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateCarRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetCarListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarResponse;
import com.example.rent_a_car_demo.services.abstracts.CarService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
@AllArgsConstructor
public class CarController {

    private final CarService carService;


    @GetMapping("/getall")
    public List<GetCarListResponse> getAllCar() {
        return this.carService.getAllCars();
    }

    @GetMapping("/get")
    public GetCarResponse getCarById(@RequestParam(value = "id") Integer id) {
        return carService.getCarById(id);
    }

    @PostMapping("/add")
    public String saveCar(@RequestBody @Valid AddCarRequest addCarRequest) {
        return carService.saveCar(addCarRequest);
    }

    @PutMapping("/update")
    public String updateCar(@RequestBody UpdateCarRequest updateCarRequest) throws Exception {
        return this.carService.updateCar(updateCarRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCar(@PathVariable Integer id) throws Exception {
        return this.carService.deleteCar(id);
    }

    @GetMapping("/Year-Greater")
    List<GetCarResponse>findByYearGreaterThan(@RequestParam Integer year){
        return this.carService.findByYearGreaterThan(year);

    }
    @GetMapping("/Year")
    List<GetCarResponse>findByYearLessThan(@RequestParam Integer year){
        return this.carService.findByYearLessThan(year);
    }
    @GetMapping("/ByColorLike")
    List<GetCarResponse>findByColorLike(@RequestParam String color){
        return this.carService.findByColorLike(color);
    }
    @GetMapping("/YearAndColor")
    List<GetCarResponse>findByYearAndColor(@RequestParam Integer year, @RequestParam String color){
        return this.carService.findByYearAndColor(year, color);
    }

}
