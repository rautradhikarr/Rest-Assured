package com.api.testing;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class createUserDataDrivenApproch2 {
	
	@DataProvider (name="createUserDDApproch")
	
	public Object[][] createUserDDApproch() {
		
		//Object [][] requestbody = new Object[4][4];
		
		return new Object[][]{
		
		{"Kiran","male","kirann@gmail.com","active"},
		{"maya","female","mayaa@gmail.com","active"},
		{"Ram","male","ramm@gmail.com","active"},
		{"Aish","female","aishh@gmail.com","active"}
		
	};

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
		.log().body();

		
		
	}

		
}

