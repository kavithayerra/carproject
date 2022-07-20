package com.trainingapps.carproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.trainingapps.carproject.entity.Car;
import com.trainingapps.carproject.exceptions.CarNotFoundException;
import com.trainingapps.carproject.repository.ICarRepository;

@Transactional
@Service
public class CarServiceImpl implements CarService {

	@Autowired
	private ICarRepository carRepository;

	@Override
	public List<Car> getCars() {
		List<Car> list = carRepository.findAll();
		return list;
	}

	@Override
	public Car saveCar(Car car) {
		car = carRepository.save(car);
		return car;
	}

	@Override
	public Car updateCar(Car change) {
		Car found = getCar(change.getId());
		found.setBrand(change.getBrand());
		found.setModel(change.getModel());
		found.setColour(change.getColour());
		found = carRepository.save(found);
		return found;

	}

	@Override
	public Car getCar(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (!optional.isPresent()) {
			throw new CarNotFoundException("car not found by id=" + id);
		}
		Car car = optional.get();
		return car;
	}

	@Override
	public void deleteCar(int id) {
		carRepository.deleteById(id);

	}

}
