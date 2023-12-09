package com.example.rent_a_car_demo.repositories;
import com.example.rent_a_car_demo.dtos.responses.getListResponses.GetUserListResponse;
import com.example.rent_a_car_demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByPhone(String phone);
    List<User>findByUsername(String username);

    List<User>findByFirstNameOrLastName(String firstName, String lastName);
    List<User>findByEmailAndPassword(String userName,String password);

    @Query("SELECT new com.example.rent_a_car_demo.dtos.responses.getListResponses.GetUserListResponse" +
            "(u.id, u.firstName, u.lastName, u.username,u.password,u.email,u.phone,u.gender,u.birthDate) " +
            "FROM User u " +
            "WHERE u.firstName LIKE %:firstName%")
    List<GetUserListResponse>findByFirstNameLike(String firstName);

    @Query("SELECT com.example.rent_a_car_demo.dtos.responses.getListResponses.GetUserListResponse" +
            "(u.id, u.firstName, u.lastName, u.username,u.password,u.email,u.phone,u.gender,u.birthDate) " +
            "FROM User u " +
            "WHERE u.gender = :gender")
    List<GetUserListResponse>findByGender(String gender);}




