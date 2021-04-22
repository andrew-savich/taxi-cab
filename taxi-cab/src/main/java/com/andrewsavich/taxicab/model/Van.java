package com.andrewsavich.taxicab.model;

public class Van extends Car implements Taxi {
	private int additionalPlaces;
	private final RideOption RIDE_OPTION;

	public Van() {
		RIDE_OPTION = RideOption.VAN;
	}

	public Van(String name, int price, int fuelConsuption, int maxSpeed, int additionalPlaces) {
		super(name, price, fuelConsuption, maxSpeed);
		this.additionalPlaces = additionalPlaces;
		RIDE_OPTION = RideOption.VAN;
	}

	public int getAdditionalPlaces() {
		return additionalPlaces;
	}

	public int getAllPlaces() {
		return additionalPlaces + 4;
	}

	public RideOption getRideOption() {
		return RIDE_OPTION;
	}

	@Override
	public double tripCost(double km, int oneKmCost) {
		return km * oneKmCost * RIDE_OPTION.getCoeffOption();

	}

	@Override
	public String toString() {
		return "Van [name=" + name + ", registrationNumber=" + registrationNumber + ", price=" + price
				+ ", fuelConsuption=" + fuelConsuption + ", maxSpeed=" + maxSpeed + ", AllPlaces=" + getAllPlaces()
				+ ", RideOption" + getRideOption() + "]";
	}

}
