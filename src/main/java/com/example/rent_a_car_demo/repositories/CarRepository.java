package com.example.rent_a_car_demo.repositories;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarResponse;
import com.example.rent_a_car_demo.models.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface CarRepository extends JpaRepository<Car, Integer> {
List<Car>findByYearGreaterThan (Integer year);
List<Car>findByYearLessThan (Integer year);
@Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarResponse" +
        "(c.year, c.color, c.rentalFee, c.licencePlate)" +
        " FROM Car c WHERE c.color LIKE %:color%")
List<GetCarResponse> findByColorLike(String color);

@Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getResponses.GetCarResponse" +
        "(c.year,c.color,c.rentalFee,c.licencePlate)" +
        " FROM Car c WHERE c.year = :year AND c.color = :color")
List<GetCarResponse>findByYearAndColor(Integer year, String color);

}
