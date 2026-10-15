package com.api.testing;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;


public class createUserDataDrivenFakerLibraryApproch2 {
	
	Faker Faker = new Faker();
	
	@DataProvider (name="createUserDDApproch")
	
	public Object[][] createUserDDApproch() {
		
		//Object [][] requestbody = new Object[4][4];
		
		return new Object[][]{
		
		{Faker.name().fullName(),Faker.demographic().sex(),Faker.internet().emailAddress(),"active"},
		{Faker.name().fullName(),Faker.demographic().sex(),Faker.internet().emailAddress(),"active"},
		{Faker.name().fullName(),Faker.demographic().sex(),Faker.internet().emailAddress(),"active"},
		{Faker.name().fullName(),Faker.demographic().sex(),Faker.internet().emailAddress(),"active"}
		
	};
//		requestbody[0][0] = "Kiran";
//		requestbody[0][1] = "male";
//		requestbody[0][2] = "Kiran@gmail.com";
//		requestbody[0][3] = "active";
//		
//		requestbody[1][0] = "maya";
//		requestbody[1][1] = "female";
//		requestbody[1][2] = "Maya@gmail.com";
//		requestbody[1][3] = "active";
//		
//		requestbody[2][0] = "kaya";
//		requestbody[2][1] = "female";
//		requestbody[2][2] = "Kaya@gmail.com";
//		requestbody[2][3] = "active";
//		
//		requestbody[3][0] = "ram";
//		requestbody[3][1] = "male";
//		requestbody[3][2] = "Ram@gmail.com";
//		requestbody[3][3] = "active";
		
		//return requestbody;

	}
	

	
		@Test (dataProvider="createUserDDApproch")

		public void createUserAPI (String name, String gender, String email, String status ) {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name",name);
		requestBody.put("gender",gender);
		requestBody.put("email",email);
		requestBody.put("status",status);
	
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestBody.toString())
		.post("https://gorest.co.in/public/v2/users")
		
		.then()
		//.statusCode(201)
		//.log().status()
		.log().body();
		//.assertThat().body("gender", oneOf("male","female"))
		//.assertThat().body("status", oneOf("active","inactive"))
		//.header("content-Type","application/json; charset=utf-8");
		//.body("name", equalTo("jjack"))
		//.time(Matchers.lessThan(2000L));
		
		
	}

		
}

