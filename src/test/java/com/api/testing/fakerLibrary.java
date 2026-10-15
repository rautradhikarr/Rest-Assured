package com.api.testing;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;



public class fakerLibrary {
	
	@Test
	public void fakerLibrartPractice() {
		
		Faker faker = new Faker();
		
		System.out.println("City Name"  + faker.address().city());
		
		
	}

}
