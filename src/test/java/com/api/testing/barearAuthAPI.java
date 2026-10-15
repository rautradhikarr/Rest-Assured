package com.api.testing;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class barearAuthAPI {
	
	@Test
	public void barearAuthTokenAPI() {
		
		given()
		.headers("accept", "application/json")
		.header("Authorization","Bearer 123456")
		
		.when()
		.get("https://httpbin.org/bearer")
		
		
		.then()
		.statusCode(200)
		.time(Matchers.lessThan(4887L))
		.header("Content-Type", "application/json")
		.assertThat().body("authenticated", oneOf(true, false))
		.log().body();
		 
		
		
	}
	
	

}
