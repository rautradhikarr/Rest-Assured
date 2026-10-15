package com.api.testing;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class postCreateUsersAssertCommands {
	
	Faker faker = new Faker();
	
	@Test
	public void createUserAPI () {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name",faker.name().firstName());
		requestBody.put("gender",faker.demographic().sex());
		requestBody.put("email",faker.internet().emailAddress());
		requestBody.put("status","active");
	
		
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestBody.toString())
		.post("https://gorest.co.in/public/v2/users");
		
		
		Assert.assertEquals(response.contentType(), "application/json; charset=utf-8");
		Assert.assertEquals(response.statusCode(), 201);
		Assert.assertEquals(response.statusLine(), "HTTP/1.1 201 Created");

		
		System.out.println("Content Type >> " +response.contentType());
		System.out.println("Status Code >> "+response.statusCode());
		System.out.println("Status Line >> "+response.statusLine());
		System.out.println("Response Time >> "+response.getTime());
		System.out.println("Response Headers >> "+response.getHeaders());
		System.out.println("Response Body >> "+response.body());

		
//		.then()
//		.statusCode(201)
//		.log().status()
//		.log().body()
//		.header("content-Type","application/json; charset=utf-8");
		//.body("name", equalTo("jjack"))
		//.time(Matchers.lessThan(2000L));
		
		
	}

}
