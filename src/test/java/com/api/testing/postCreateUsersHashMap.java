package com.api.testing;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;
public class postCreateUsersHashMap {
	
	@Test
	public void createUserApi() {
		
		HashMap<String, String> requestBody = new HashMap<String, String>();
		requestBody.put("name", "Ishant");
		requestBody.put("gender", "male");
		requestBody.put("email", "ishantiii@gmail.com");
		requestBody.put("status", "active");
		
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.body(requestBody)
		.post("https://gorest.co.in/public/v2/users")
		
		.then()
		//.log().all()//print all body headers
				.log().status()
				.log().body()//print response body
				//.log().headers()//print response headers
				.statusCode(201);//verify if status code is 200
				//.body("gender", hasItems("male","female"));
				//.body("gender", hasItems("male","female"))
				//.body("status", hasItems("active","inactive"))
				//.header("content-Type","application/json; charset=utf-8");
				//.body("[0].name", equalTo("Baala Ganaka"))
				//.body("[5].status", equalTo("inactive"));
		
	}

	
}
