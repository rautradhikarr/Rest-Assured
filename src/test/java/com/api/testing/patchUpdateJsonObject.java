package com.api.testing;

import org.testng.annotations.Test;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class patchUpdateJsonObject {
	@Test
	public void patchUpdate() {
		
		JSONObject requestbody = new JSONObject();
		requestbody.put("name", "Ram");
		requestbody.put("email", "Ram@gmail.com");
		requestbody.put("status", "active");
		
		
		given()
		.header("Accept", "application/json")
		.header("content-Type", "application/json")
		.header("Authorization", "Bearer a1acf13036e08546446ebcbeb75b11959fbcc0795218a185cfc982f6982c29")	
		
	
		.when()
		.body(requestbody.toString())
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
