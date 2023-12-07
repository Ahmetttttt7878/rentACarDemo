package com.example.rent_a_car_demo.repositories;

import com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse;
import com.example.rent_a_car_demo.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Integer> {
    List<Address> findByCountryOrCity(String address, String city);

    List<Address> findByCityLike(String city);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse" +
            "(a.address, a.country, a.region, a.city, a.zipCode, a.user.username) " +
            "FROM addresses a " +
            "WHERE a.country = :country")
    List<GetAddressResponse> findByCountry(String country);


    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetAddressResponse" +
            "(a.address, a.country, a.region, a.city, a.zipCode, a.user.username)" +
            "FROM addresses a " +
            "WHERE a.address = :address")
    List<GetAddressResponse> findByAddress(String address);

}
