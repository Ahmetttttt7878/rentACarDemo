package com.example.rent_a_car_demo.services.concretes;

import com.example.rent_a_car_demo.dtos.requests.addRequests.AddAddressRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateAddressRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetAddressListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse;
import com.example.rent_a_car_demo.models.Address;
import com.example.rent_a_car_demo.repositories.AddressRepository;
import com.example.rent_a_car_demo.services.abstracts.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressManager implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressManager(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<GetAddressListResponse> getAllAddresses() {
        List<Address> addresses = this.addressRepository.findAll();
        List<GetAddressListResponse> response = new ArrayList<>();



        for (Address address : addresses) {
            GetAddressListResponse listResponse = new GetAddressListResponse();

            listResponse.setAddress(address.getAddress());
            listResponse.setCity(address.getCity());
            listResponse.setCountry(address.getCountry());
            listResponse.setRegion(address.getRegion());
            listResponse.setZipCode(address.getZipCode());
            listResponse.setUsername(address.getUser().getUsername());


            response.add(listResponse);


        }
        return response;

    }


    public GetAddressResponse getAddressById(int id) {
        Address address = this.addressRepository.getReferenceById(id);
        GetAddressResponse response = new GetAddressResponse();

        response.setAddress(address.getAddress());
        response.setCity(address.getCity());
        response.setRegion(address.getRegion());
        response.setUsername(address.getUser().getUsername());
        response.setZipCode(address.getZipCode());
        response.setCountry(address.getCountry());

        return response;


    }

    public void saveAddress(AddAddressRequest address) {

        Address createAddress = new Address();

        createAddress.setAddress(address.getAddress());
        createAddress.setCity(address.getCity());
        createAddress.setRegion(address.getRegion());
        createAddress.setUser(address.getUser());
        createAddress.setZipCode(address.getZipCode());
        createAddress.setCountry(address.getCountry());

        addressRepository.save(createAddress);
    }


    public void updateAddress(int id, UpdateAddressRequest address) {

        Address createAddress = this.addressRepository.getReferenceById(id);

        createAddress.setAddress(address.getAddress());
        createAddress.setCity(address.getCity());
        createAddress.setRegion(address.getRegion());
        createAddress.setUser(address.getUser());
        createAddress.setZipCode(address.getZipCode());
        createAddress.setCountry(address.getCountry());

        addressRepository.save(createAddress);
    }

    public void deleteAddress(int id) {
        addressRepository.deleteById(id);
    }

    @Override
    public List<GetAddressResponse> findByCountryOrCity(String country, String city) {
        List<Address> addresses = addressRepository.findByCountryOrCity(country, city);
        List <GetAddressResponse> response = new ArrayList<>();

        for (Address address : addresses) {
            GetAddressResponse getResponse = new GetAddressResponse();

            getResponse.setCountry(address.getCountry());
            getResponse.setCity(address.getCity());
            getResponse.setAddress(address.getAddress());
            getResponse.setRegion(address.getRegion());
            getResponse.setZipCode(address.getZipCode());
            getResponse.setUsername(address.getUser().getUsername());
            response.add(getResponse);


        }
        return response;
    }
    public List<GetAddressResponse>findByCityLike(String city){
        List<Address> addresses = addressRepository.findByCityLike(city);
        List<GetAddressResponse> response = new ArrayList<>();

        for (Address address : addresses) {
            GetAddressResponse getResponse = new GetAddressResponse();
            getResponse.setCountry(address.getCountry());
            getResponse.setCity(address.getCity());
            getResponse.setAddress(address.getAddress());
            getResponse.setRegion(address.getRegion());
            getResponse.setZipCode(address.getZipCode());
            getResponse.setUsername(address.getUser().getUsername());
            response.add(getResponse);



        }
        return response;
    }

    @Override
    public List<GetAddressResponse> findByCountry(String country) {
        return this.addressRepository.findByCountry(country);
    }

    @Override
    public List<GetAddressResponse> findByAddress(String address) {
        return this.addressRepository.findByAddress(address);
    }


}