package com.andrewsavich.taxicab.carsloaders;

import java.util.List;

import com.andrewsavich.taxicab.model.Car;

public interface CarsLoader {
	public List<Car> loadCars();
}
