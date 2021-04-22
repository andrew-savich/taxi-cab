package com.andrewsavich.taxicab.model;

class RegistrationNumberCreater {
	private static int currentRegistretionNumber = 0;
	
	private RegistrationNumberCreater() {};
	
	public static String getRegistrationNumber() {
		if (currentRegistretionNumber < 10) 
			return "000" + currentRegistretionNumber++;
		
		if (currentRegistretionNumber < 100) 
			return "00" + currentRegistretionNumber++;
		
		if (currentRegistretionNumber < 100) 
			return "0" + currentRegistretionNumber++;
		
		return Integer.toString(currentRegistretionNumber++);
	}
}
