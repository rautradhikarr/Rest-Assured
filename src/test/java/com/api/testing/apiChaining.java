package com.api.testing;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;



public class apiChaining {
	
			Faker faker = new Faker();
			int ExtractedID;
			@Test (priority= 1)
			
			//Create function/create user test case
		
			public void createUserApi() {
			
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
			
			System.out.println("ID is"+ ExtractedID);
			
			//.then()
			//.log().all()//print all body headers
					//.log().status()
					//.log().body()//print response body
					//.log().headers()//print response headers
					//.statusCode(201);//verify if status code is 200
					//.body("gender", hasItems("male","female"));
					//.body("gender", hasItems("male","female"))
					//.body("status", hasItems("active","inactive"))
					//.header("content-Type","application/json; charset=utf-8");
					//.body("[0].name", equalTo("Baala Ganaka"))
					//.body("[5].status", equalTo("inactive"));
			
		}

		//Create function/update user test case
		@Test (priority=2)
	
		public void updateUserAPI(){
		
		HashMap<String, String> requestbody = new HashMap<String, String>();
		requestbody.put("name", faker.name().prefix()+ faker.name().firstName()+ faker.name().lastName());
		requestbody.put("email", faker.internet().emailAddress());
		requestbody.put("status", "active");
		
		
		given()
		.header("Accept", "application/json")
		.header("content-Type", "application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestbody)
		.patch("https://gorest.co.in/public/v2/users/"+ ExtractedID)
		
		.then()
		//.log().status()
		//.statusCode(200)
		.log().body();
		System.out.println("Updated ID is"+ ExtractedID);
		//.statusLine("HTTP/1.1 200 OK")
		//.header("content-Type", "application/json; charset=utf-8");
		//.time(Matchers.lessThan(2000L));
	}

		//Create function/delete user test case
		@Test (priority=3)
		
		public void deleteUser(){
			

			given()
			.header("Accept", "application/json")
			.header("content-Type", "application/json")
			.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")	
			
		
			.when()
			.delete("https://gorest.co.in/public/v2/users/"+ExtractedID)
			
			.then()
			.log().status()
			.statusCode(204)
			.log().body()
			.statusLine("HTTP/1.1 200 OK")
			.header("content-Type", "application/json; charset=utf-8");
			System.out.println("Deleted ID is"+ ExtractedID);

			//.time(Matchers.lessThan(2000L));
			
			
		}

		
	}


