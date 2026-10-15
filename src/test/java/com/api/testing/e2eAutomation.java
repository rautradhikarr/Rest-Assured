package com.api.testing;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

public class e2eAutomation {
	
	int ExtractedID;

	@Test (priority= 1)

	public void createUser() {
		
		Faker faker = new Faker();
		
		//Create function/create user test case
	
		HashMap<String, String> requestBody = new HashMap<String, String>();
		requestBody.put("name",faker.name().firstName());
		requestBody.put("gender",faker.demographic().sex());
		requestBody.put("email",faker.internet().emailAddress());
		requestBody.put("status","active");
		
		ExtractedID=given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestBody)
		.post("https://gorest.co.in/public/v2/users").
		jsonPath().getInt("id");
		
		System.out.println("Created ID is "+ ExtractedID);
		
	}
		
		//VERIFY IF USER IS CREATED (GET)
		@Test (priority=2)
		
		public void verifyIfUserIsCreated(){
		
		given()
		.header("Accept", "application/json")
		.header("content-Type", "application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.get("https://gorest.co.in/public/v2/users/"+ ExtractedID)
		
		.then()
		.log().body();
		//.body("id",equalTo(+ExtractedID));
		System.out.println("ID present is "+ ExtractedID);
		
	}
		
		
		//UPDATE THE CREATED USER (PATCH)
		
		@Test (priority=3)
		
		public void updateTheCreatedUser(){
		
		HashMap<String, String> requestbody = new HashMap<String, String>();
		
		given()
		.header("Accept", "application/json")
		.header("content-Type", "application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestbody)
		.patch("https://gorest.co.in/public/v2/users/"+ ExtractedID)
		
		.then()
		.log().body();
		System.out.println("Updated ID is"+ ExtractedID);
		
	}
		//VERIFY IF USER IS UPDATED (GET)
		@Test (priority=4)
		
		public void verifyIfUserIsUpdated(){
			
			given()
			.header("Accept", "application/json")
			.header("content-Type", "application/json")
			.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
			
			.when()
			.get("https://gorest.co.in/public/v2/users/"+ ExtractedID)
			
			.then()
			.log().body();
			System.out.println("ID is Updated "+ ExtractedID);
			
		}
		
			@Test (priority=5)
		
			public void deleteTheCreatedUser(){
			
			given()
			.header("Accept", "application/json")
			.header("content-Type", "application/json")
			.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")	
			
		
			.when()
			.delete("https://gorest.co.in/public/v2/users/"+ExtractedID)
			
			.then()
			.log().status()
			.log().body();
			System.out.println("Deleted ID is"+ ExtractedID);			
			
		}
		
			//VERIFY IF ID IS DELETED
			@Test (priority=6)
			
			public void verifyThedeletedUser(){
			
			given()
			.header("Accept", "application/json")
			.header("content-Type", "application/json")
			.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")	
			
		
			.when()
			.get("https://gorest.co.in/public/v2/users/"+ExtractedID)
			
			.then()
			.log().status()
			.log().body();
			System.out.println("Deleted ID is"+ ExtractedID);			
			
		}
			
			//GET ALL USERS
			@Test (priority=7)
			
			public void fetchAllUsers(){
			
			given()
			.header("Accept", "application/json")
			.header("content-Type", "application/json")
			.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")				
		
			.when()
			.get("https://gorest.co.in/public/v2/users")
			
			.then()
			.log().status()
			.log().body();
			System.out.println("All User Are Present");			
			
		}
	}


