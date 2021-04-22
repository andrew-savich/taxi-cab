package com.andrewsavich.taxicab.model;

public class Wagon extends Car implements Taxi {
	private int trunkVolume;
	private final RideOption RIDE_OPTION;

	public Wagon() {
		RIDE_OPTION = RideOption.WAGON;
	}

	public Wagon(String name, int price, int fuelConsuption, int maxSpeed, int trunkVolume) {
		super(name, price, fuelConsuption, maxSpeed);
		this.trunkVolume = trunkVolume;
		RIDE_OPTION = RideOption.WAGON;
	}

	public RideOption getRideOption() {
		return RIDE_OPTION;
	}

	public int getTrunkVolume() {
		return trunkVolume;
	}

	@Override
	public double tripCost(double km, int oneKmCost) {
		return km * oneKmCost * RIDE_OPTION.getCoeffOption();

	}

	@Override
	public String toString() {
		return "Wagon [name=" + name + ", registrationNumber=" + registrationNumber + ", price=" + price
				+ ", fuelConsuption=" + fuelConsuption + ", maxSpeed=" + maxSpeed + ", RideOption" + getRideOption()
				+ ", TrunkVolume" + getTrunkVolume() + "]";
	}

}
