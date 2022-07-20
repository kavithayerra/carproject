package com.trainingapps.carproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trainingapps.carproject.entity.Car;
import com.trainingapps.carproject.service.CarService;

@RequestMapping("/cars")
@RestController
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/get/byid/{carId}")
	public Car fetchCar(@PathVariable int carId) {
		Car car=carService.getCar(carId);
		return car;
	}
	
	@PostMapping("/add")
	public Car addCar(@RequestBody Car requestData) {
		Car saved=carService.saveCar(requestData);
	   return saved;
	}
	
	@PutMapping("/update")
	public Car updateCar(@RequestBody Car requestData) {
		Car updated=carService.updateCar(requestData);
		return updated;
	}
	
	@DeleteMapping("/delete/{carId}")
	public String deleteCar(@PathVariable int carId) {
		carService.deleteCar(carId);
		return "deleted car "+carId;
	}
	
}
