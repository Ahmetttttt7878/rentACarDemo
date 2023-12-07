package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddBrandRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateBrandRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetBrandListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.services.abstracts.BrandService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/brands")
@AllArgsConstructor
public class BrandsController {

    private final BrandService brandService;
    @GetMapping("/getall")
    public List<GetBrandListResponse> getBrandList() {

       return  this.brandService.getBrandList();
    }

    @GetMapping("/{id}")
    public GetBrandResponse getBrandById(@PathVariable int id) {
        return this.brandService.getBrandById(id);
    }

    @PostMapping("/create")
    public String createBrand(@RequestBody AddBrandRequest addBrandRequest) {

        return this.brandService.createBrand(addBrandRequest);
    }

    @PutMapping("/update")
    public String updateBrand(@RequestBody UpdateBrandRequest updateBrandRequest) throws Exception {

        return this.brandService.updateBrand(updateBrandRequest);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBrand(@PathVariable int id) throws Exception {

        return this.brandService.deleteByBrand(id);
    }

    @GetMapping("/StartingWith")
    List<GetBrandResponse>getByNameStartingWith(@RequestParam String name){
        return this.brandService.findByNameStartingWith(name);
    }
    @GetMapping("/EndingWith")
    List<GetBrandResponse>getByEndingWith(@RequestParam String name){
        return this.brandService.findByNameEndingWith(name);
    }
    @GetMapping("/ByName")
    List<GetBrandResponse>findByName(@RequestParam String name){
        return this.brandService.findByName(name);
    }
    @GetMapping("/Igorename")
    List<GetBrandResponse>firstIgorename(@RequestParam String name){
        return this.brandService.findByFirstnameIgnoreCase(name);
    }

}
