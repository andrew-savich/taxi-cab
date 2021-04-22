package com.andrewsavich.taxicab.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class TaxiCabTest {

	private static TaxiCabService underTest;

	@BeforeAll
	public static void init() {
		underTest = new TaxiCab("Some taxi cab");
	}

	@Test
	public void findCarByRegistrationNumber_shouldThrowExceptionIfWrongRegNum() {
		String regNumber = "wrong";

		assertThrows(IllegalArgumentException.class, () -> underTest.findCarByRegistrationNumber(regNumber));
	}

	@Test
	public void calcPriceOfAllCars_shouldReturnZeroIsTaxiCabIsEmpty() {

		assertEquals(0, underTest.calcPriceOfAllCars());
	}

	@ParameterizedTest
	@MethodSource("speedValues")
	public void findBySpeedRange_shouldThrowExceptionIfWrongRange(int minSpeed, int maxSpeed) {
		
		assertThrows(IllegalArgumentException.class, () -> underTest.findBySpeedRange(minSpeed, maxSpeed));
	}

	private static Stream<Arguments> speedValues() {
		return Stream.of(Arguments.of(200, 100), Arguments.of(-5, 120), Arguments.of(100, -10));
	}

}
