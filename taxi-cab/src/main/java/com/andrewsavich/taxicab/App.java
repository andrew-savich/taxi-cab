package com.andrewsavich.taxicab;

import com.andrewsavich.taxicab.carsloaders.JSONCarsLoader;
import com.andrewsavich.taxicab.model.Sedan;
import com.andrewsavich.taxicab.model.Van;
import com.andrewsavich.taxicab.model.Wagon;
import com.andrewsavich.taxicab.services.TaxiCab;

public class App {
	public static void main(String[] args) {

		TaxiCab yandexTaxi = new TaxiCab("Yandex Taxi", 2.5);

		yandexTaxi.addCarsFromList(new JSONCarsLoader("sedans.json", Sedan.class).loadCars());
		yandexTaxi.addCarsFromList(new JSONCarsLoader("vans.json", Van.class).loadCars());
		yandexTaxi.addCarsFromList(new JSONCarsLoader("wagons.json", Wagon.class).loadCars());

		System.out.println("cars before sort:");
		yandexTaxi.showAllCars();
		System.out.println();

		yandexTaxi.sortByFuelConsuption();
		System.out.println("cars after sort:");
		yandexTaxi.showAllCars();

		System.out.println("find by speed:");
		System.out.println(yandexTaxi.findBySpeedRange(178, 200));

	}
}
