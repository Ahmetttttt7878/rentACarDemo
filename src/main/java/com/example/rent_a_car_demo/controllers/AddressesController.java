package com.example.rent_a_car_demo.controllers;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse;
import com.example.rent_a_car_demo.services.abstracts.AddressService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/addresses")
@AllArgsConstructor
public class AddressesController {

    private final AddressService addressService;


    @GetMapping("/getall")
    public List<GetAddressListResponse> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("/get")
    public GetAddressResponse getAddressById(@RequestParam(value = "id") Integer id) {
        return addressService.getAddressById(id);
    }

    @PostMapping("/add")
    public void saveAddress(@RequestBody @Valid AddAddressRequest request) {
        addressService.saveAddress(request);
    }

    @PutMapping("/{id}")
    public void updateAddress(@PathVariable Integer id, @RequestBody UpdateAddressRequest address) {

        addressService.updateAddress(id, address);
    }
    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable Integer id) {
        addressService.deleteAddress(id);
    }

        @GetMapping("/CountryOrCity")
        public List<GetAddressResponse> findByCountryOrCity (@RequestParam String country, @RequestParam String city){

            return addressService.findByCountryOrCity(country, city);
        }

        @GetMapping("/City")
        public List<GetAddressResponse> findByCityLike (@RequestParam String city){
            return addressService.findByCityLike(city);
        }

        @GetMapping("/Country")
        public List<GetAddressResponse> findByCountry (@RequestParam String country){
            return addressService.findByCountry(country);
        }

        @GetMapping("/Address")
        public List<GetAddressResponse> findByAddress (@RequestParam String address){
            return addressService.findByAddress(address);
        }

    }
