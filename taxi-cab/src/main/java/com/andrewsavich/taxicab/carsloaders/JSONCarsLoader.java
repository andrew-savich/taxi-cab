package com.andrewsavich.taxicab.carsloaders;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.andrewsavich.taxicab.model.Car;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JSONCarsLoader implements CarsLoader {
	
	private String fileName;
	private Class<? extends Car> clazz;
	private List<Car> allCars;
	private ClassLoader classLoader;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(JSONCarsLoader.class);

	public JSONCarsLoader(String fileName, Class<? extends Car> clazz) {
		this.fileName = fileName;
		this.clazz = clazz;
		allCars = new ArrayList<>();
		classLoader = getClass().getClassLoader();
	}

	public List<Car> loadCars() {
		LOGGER.info("starting to try load cars from file called: " + fileName);

		if (classLoader.getResource(fileName) == null) {
			throw new IllegalArgumentException("Wrong file name, or file no exist");
		}

		File jsonFile = new File(classLoader.getResource(fileName).getFile());
		LOGGER.info("connected to JSON file with array of cars: " + clazz.getSimpleName());

		try {

			ObjectMapper mapper = new ObjectMapper();
			TypeFactory type = TypeFactory.defaultInstance();

			allCars = mapper.readValue(jsonFile, type.constructCollectionType(ArrayList.class, clazz));

		} catch (JsonParseException e) {
			System.err.println("JSON file: " + fileName + "  with invalid syntax. Details: " + e);
		} catch (JsonMappingException e) {
			System.err.println("Problems in " + fileName + "  with convert JSON data. Details: " + e);
		} catch (IOException e) {
			System.err.println("Problems with opening a JSON file:  " + fileName + "  ! Details: " + e);
		}
			LOGGER.info("Items from " + fileName + " was loaded");
		return new ArrayList<>(allCars);

	}

}
