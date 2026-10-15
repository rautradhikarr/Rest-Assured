package com.api.testing;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

import static io.restassured.RestAssured.*;


public class deleteUserDataDrivenApproch2 {
	
	Faker Faker = new Faker();
	
	@DataProvider (name="deleteUserDDApproch")
	
	public Object[] deleteUserDDApproch() {
		
		//Object [][] requestbody = new Object[4][4];
		
		return new Object[] {
		
			8662346,8662347,8662348,8662349
		
	};

	}
	

	
		@Test (dataProvider="deleteUserDDApproch")

		public void deleteUserAPI (Object idToDelete) {
		
	
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		
		.delete("https://gorest.co.in/public/v2/users/"+idToDelete)
		
		.then()
		.log().status();
	
		
		
	}

		
}

