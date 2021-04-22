package com.andrewsavich.taxicab.model;

public enum RideOption {
	ECONOMY(1.0), COMFORT(1.2), PREMIUM(2), VAN(1.5), WAGON(1.3);

	private double coeffOption;

	private RideOption(double coeffOption) {
		this.coeffOption = coeffOption;
	}

	public double getCoeffOption() {
		return coeffOption;
	}

}
