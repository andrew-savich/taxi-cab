package com.andrewsavich.taxicab.carsloaders;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.andrewsavich.taxicab.model.Sedan;

public class JSONCarsLoaderTest {

	@Test
	public void loadCars_shouldThrowExceptionIfFileNotFound() {
		JSONCarsLoader carsLoader = new JSONCarsLoader("wrong.name", Sedan.class);

		Assertions.assertThrows(IllegalArgumentException.class, () -> carsLoader.loadCars());
	}

}
