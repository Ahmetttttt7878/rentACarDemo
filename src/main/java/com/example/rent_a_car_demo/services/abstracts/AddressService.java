package com.example.rent_a_car_demo.services.abstracts;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse;

import java.util.List;

public interface AddressService {
    List<GetAddressListResponse> getAllAddresses();
    GetAddressResponse getAddressById(int id);
    void saveAddress(AddAddressRequest request) throws Exception;
    void updateAddress(int id, UpdateAddressRequest address);
    void deleteAddress(int id);


     List<GetAddressResponse>findByCountryOrCity(String country, String city);
     List<GetAddressResponse>findByCityLike(String city);
     List<GetAddressResponse>findByCountry(String country);
     List<GetAddressResponse>findByAddress(String address);


}
