package com.api.testing;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import java.util.HashMap;


public class patchUpdateUserHashMap {
	
	@Test
	public void updateUserAPI(){
		
		HashMap<String, String> requestbody = new HashMap<String, String>();
		requestbody.put("name", "Yogii");
		requestbody.put("email", "Yogii@gmail.com");
		requestbody.put("status", "active");
		
		
		given()
		.header("Accept", "application/json")
		.header("content-Type", "application/json")
		.header("Authorization", "Bearer a1acf13036e08546446ebcbeb75b11959fbcc0795218a185cfc982f6982c29")
		
		.when()
		.body(requestbody)
		.patch("https://gorest.co.in/public/v2/users/8640909")
		
		.then()
		.log().status()
		.statusCode(200)
		.log().body()
		.statusLine("HTTP/1.1 200 OK")
		.header("content-Type", "application/json; charset=utf-8");
		//.time(Matchers.lessThan(2000L));
	}

}
