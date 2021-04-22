package com.andrewsavich.taxicab.services;

import java.util.List;

import com.andrewsavich.taxicab.model.Car;

public interface TaxiCabService {

	void addCarsFromList(List<Car> cars);

	void addCar(Car car);
	
	List<Car> getAllCars();

	int calcPriceOfAllCars();

	void sortByFuelConsuption();

	List<Car> findBySpeedRange(int minSpeed, int maxSpeed);
	
	Car findCarByRegistrationNumber(String registrationNumber);

	void showAllCars();

}