package com.andrewsavich.taxicab.model;

public class Car {
	
	protected String name;
	protected String registrationNumber;
	protected int price;
	protected double fuelConsuption;
	protected int maxSpeed;

	public Car() {
		registrationNumber = RegistrationNumberCreater.getRegistrationNumber();
	}

	public Car(String name, int price, double fuelConsuption, int maxSpeed) {
		this.name = name;
		this.price = price;
		this.fuelConsuption = fuelConsuption;
		this.maxSpeed = maxSpeed;
		registrationNumber = RegistrationNumberCreater.getRegistrationNumber();
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	public Double getFuelConsuption() {
		return fuelConsuption;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}
	
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String toString() {
		return "Car [name=" + name + ", registrationNumber=" + registrationNumber + ", price=" + price
				+ ", fuelConsuption=" + fuelConsuption + ", maxSpeed=" + maxSpeed + "]";
	}
	
}
