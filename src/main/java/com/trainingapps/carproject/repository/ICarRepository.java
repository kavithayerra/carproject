package com.trainingapps.carproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainingapps.carproject.entity.Car;

public interface ICarRepository extends JpaRepository<Car, Integer>{

}
