package com.example.rent_a_car_demo.services.concretes;
import com.example.rent_a_car_demo.dtos.requests.addRequests.AddRentalRequest;
import com.example.rent_a_car_demo.dtos.requests.updateRequests.UpdateRentalRequest;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetRentalListResponse;
import com.example.rent_a_car_demo.dtos.responses.getResponses.GetRentalResponse;
import com.example.rent_a_car_demo.models.Car;
import com.example.rent_a_car_demo.models.Employee;
import com.example.rent_a_car_demo.models.Rental;
import com.example.rent_a_car_demo.models.User;
import com.example.rent_a_car_demo.repositories.CarRepository;
import com.example.rent_a_car_demo.repositories.EmployeeRepository;
import com.example.rent_a_car_demo.repositories.RentalRepository;
import com.example.rent_a_car_demo.repositories.UserRepository;
import com.example.rent_a_car_demo.services.abstracts.RentalService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class RentalManager implements RentalService {
    private RentalRepository rentalRepository;
    private CarRepository carRepository;
    private EmployeeRepository employeeRepository;
    private UserRepository userRepository;
    public List<GetRentalListResponse> getRentalList() {
        List<Rental> rentalList = rentalRepository.findAll();
        List<GetRentalListResponse> getRentalListResponse = new ArrayList<>();

        for (Rental rental : rentalList) {
            GetRentalListResponse response = new GetRentalListResponse();
            response.setId(rental.getId());
            getRentalListResponse.add(response);
        }
        return getRentalListResponse;
    }

    public GetRentalResponse getRentalById(Integer id){
        Rental rental = rentalRepository.findById(id).orElseThrow();

        GetRentalResponse dto = new GetRentalResponse();

        dto.setRentalStartDate(rental.getRentalStartDate());
        dto.setRentalEndDate(rental.getRentalEndDate());

        return dto;
    }
    public String createRental(AddRentalRequest addRentalRequest) {
        Rental rental = new Rental();
        Car car = carRepository.findById(addRentalRequest.getCarId()).orElseThrow();
        Employee employee = employeeRepository.findById(addRentalRequest.getEmployeeId()).orElseThrow();
        User user = userRepository.findById(addRentalRequest.getUserId()).orElseThrow();
        rental.setRentalStartDate(addRentalRequest.getRentalStartDate());
        rental.setRentalEndDate(addRentalRequest.getRentalEndDate());
        rental.setTotalCost(addRentalRequest.getTotalCost());
        rental.setEmployee(employee);
        rental.setUser(user);
        rental.setCar(car);
        rentalRepository.save(rental);
        return "Rental Created";
    }
    public String updateRental(UpdateRentalRequest updateRentalRequest) {
        Rental rental = rentalRepository.findById(updateRentalRequest.getId()).orElseThrow();
        rental.setRentalStartDate(updateRentalRequest.getRentalStartDate());
        rental.setRentalEndDate(updateRentalRequest.getRentalEndDate());
        rental.setTotalCost(updateRentalRequest.getTotalCost());
        rentalRepository.save(rental);
        return "Rental Updated";
    }
    public String deleteByRental(Integer id)  {
       this.rentalRepository.findById(id).orElseThrow();
       this.rentalRepository.deleteById(id);
       return "Deletion successful";
    }

}
