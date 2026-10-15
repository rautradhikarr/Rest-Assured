package com.api.testing;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class basicAuthAPI {
	
	@Test
	public void basicAuthenticationAPI() {
		
		given()
		.header("Accept", "application/json")
		.auth().basic("user","passwd")
		
		.when()
		.get("https://httpbin.org/basic-auth/user/passwd")
		
		.then()
		.statusCode(200)
		.time(Matchers.lessThan(4887L))
		.header("Content-Type", "application/json")
		.assertThat().body("authenticated", oneOf(true, false))
		.log().body();
		
		
	}

}
