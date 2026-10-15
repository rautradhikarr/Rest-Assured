package com.api.testing;

import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;


public class postCreateUsersJsonObject {
	
	@Test
	public void createUserAPI () {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name","jjack");
		requestBody.put("gender","male");
		requestBody.put("email","jjjack@gmail.com");
		requestBody.put("status","active");
	
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestBody.toString())
		.post("https://gorest.co.in/public/v2/users")
		
		.then()
		.statusCode(201)
		.log().status()
		.log().body()
		.header("content-Type","application/json; charset=utf-8")
		//.body("name", equalTo("jjack"))
		.time(Matchers.lessThan(2000L));
		
		
	}

}
