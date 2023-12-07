package com.example.rent_a_car_demo.repositories;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse;
import com.example.rent_a_car_demo.models.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface BrandRepository extends JpaRepository<Brand,Integer> {
    List<Brand> findByNameStartingWith(String name);
    List<Brand> findByNameEndingWith(String name);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse(e.name)" +
            " e FROM brands e WHERE e.name LIKE %:name%")
    List<GetBrandResponse>findByName(String name);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetBrandResponse(e.name)" +
            " e FROM brands e WHERE LOWER(e.name) = LOWER (:name)")
    List<GetBrandResponse> findByFirstnameIgnoreCase( String name);

}
