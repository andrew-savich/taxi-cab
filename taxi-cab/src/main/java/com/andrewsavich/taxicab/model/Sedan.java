package com.andrewsavich.taxicab.model;

public class Sedan extends Car implements Taxi {

	private RideOption rideOption;

	public Sedan() {
	}

	public Sedan(String name, int price, double fuelConsuption, int maxSpeed, RideOption rideOption) {
		super(name, price, fuelConsuption, maxSpeed);
		System.out.println("made Sedan");
		this.rideOption = rideOption;
	}

	public RideOption getRideOption() {
		return rideOption;
	}

	@Override
	public double tripCost(double km, int oneKmCost) {
		return km * oneKmCost * rideOption.getCoeffOption();
	}

	@Override
	public String toString() {
		return "Sedan [name=" + name + ", registrationNumber=" + registrationNumber + ", rideOption=" + rideOption
				+ ", price=" + price + ", fuelConsuption=" + fuelConsuption + ", maxSpeed=" + maxSpeed + "]";
	}

}
