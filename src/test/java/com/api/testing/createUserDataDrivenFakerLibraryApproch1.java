package com.api.testing;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class createUserDataDrivenFakerLibraryApproch1 {
	
	Faker Faker = new Faker();
	
	@DataProvider (name="createUserDDApproch")
	
	public Object createUserDDApproch() {
		
		Object [][] requestbody = new Object[4][4];
		
		requestbody[0][0] = Faker.name().fullName();
		requestbody[0][1] = Faker.demographic().sex();
		requestbody[0][2] = Faker.internet().emailAddress();
		requestbody[0][3] = "active";
		
		requestbody[1][0] = Faker.name().fullName();
		requestbody[1][1] = Faker.demographic().sex();
		requestbody[1][2] = Faker.internet().emailAddress();
		requestbody[1][3] = "active";
		
		requestbody[2][0] = Faker.name().fullName();
		requestbody[2][1] = Faker.demographic().sex();
		requestbody[2][2] = Faker.internet().emailAddress();
		requestbody[2][3] = "active";
		
		requestbody[3][0] = Faker.name().fullName();
		requestbody[3][1] = Faker.demographic().sex();
		requestbody[3][3] = "active";
		
		return requestbody;

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

