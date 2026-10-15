package com.api.testing;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;




public class digestAuthenticationAPI {
	
	@Test
	public void digestAuthAPI() {
		
		given()
		.headers("accept", "appliction/json")
		.auth().digest("user", "password")
		
		.when()
		.get("https://httpbin.org/digest-auth/undefined/user/password")
		
		.then()
		.statusCode(200)
		.time(Matchers.lessThan(4887L))
		.header("Content-Type", "application/json")
		.assertThat().body("authenticated", oneOf(true, false))
		.log().body();
		
	}

}
