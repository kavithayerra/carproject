package com.trainingapps.carproject.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.trainingapps.carproject.entity.Car;

@Validated
public interface CarService {
	List<Car> getCars();

    Car saveCar(@Valid Car car);

    
	Car getCar(@Min(1)int theId);

	Car updateCar(@Valid Car change ) ;
	
	
	void deleteCar(@Min(1) int id);
	
}
