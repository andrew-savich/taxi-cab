package com.andrewsavich.taxicab.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewsavich.taxicab.model.Car;

public class TaxiCab implements TaxiCabService {

	private String name;
	private double oneKmCost;
	private List<Car> cars;

	private static final Logger LOGGER = LoggerFactory.getLogger(TaxiCab.class);

	public TaxiCab(String name) {
		cars = new ArrayList<>();
		this.name = name;
	}

	public TaxiCab(String name, double oneKmCost) {
		this.name = name;
		this.oneKmCost = oneKmCost;
		cars = new ArrayList<>();
	}

	public String getTaxiCabName() {
		return name;
	}

	public void setTaxiCabName(String name) {
		this.name = name;
	}

	public double getOneKmCost() {
		return oneKmCost;
	}

	public void setOneKmCost(double oneKmCost) {
		this.oneKmCost = oneKmCost;
	}

	@Override
	public List<Car> getAllCars() {
		return new ArrayList<>(cars);
	}

	@Override
	public int calcPriceOfAllCars() {
		LOGGER.info("Calculating price of all cars");

		if (!cars.isEmpty()) {
			int priceOfAllCars = 0;

			for (Car car : cars)
				priceOfAllCars += car.getPrice();

			return priceOfAllCars;
		}

		else
			return 0;
	}

	@Override
	public void sortByFuelConsuption() {
		LOGGER.info("Sorting all cars");
		cars.sort((Car car1, Car car2) -> car1.getFuelConsuption().compareTo(car2.getFuelConsuption()));
	}

	@Override
	public List<Car> findBySpeedRange(int minSpeed, int maxSpeed) {

		if (minSpeed > maxSpeed || minSpeed < 0 || maxSpeed < 0) {
			LOGGER.error("Wrong range of speed");
			throw new IllegalArgumentException("Wrong range of speed");
		}
			

		LOGGER.info("Looking for cars by speed range");
		List<Car> carsOfSpeedRange = new ArrayList<>();

		for (Car car : cars) {
			if ((car.getMaxSpeed() >= minSpeed) && (car.getMaxSpeed() <= maxSpeed))
				carsOfSpeedRange.add(car);
		}
		return carsOfSpeedRange;
	}

	@Override
	public void showAllCars() {
		if (cars.isEmpty())
			System.out.println("Taxi Cab don't have any cars");
		else
			for (Car car : cars)
				System.out.println(car);

	}

	@Override
	public void addCarsFromList(List<Car> cars) {
		this.cars.addAll(cars);
	}

	@Override
	public void addCar(Car car) {
		cars.add(car);
	}

	@Override
	public Car findCarByRegistrationNumber(String registrationNumber) {

		for (Car car : cars) {
			if (car.getRegistrationNumber().equals(registrationNumber))
				return car;
		}

		throw new IllegalArgumentException("Car with number: " + registrationNumber + " doesn't exist");
	}

}
