package com.api.testing;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class oAuth2API {

	@Test
	public void oAuth() {
		
		
		given()
		.header("accept","application.json")
		.auth().oauth2("")
		
		.when()
		.get("")
		
		.then()
		.statusCode(200)
		.time(Matchers.lessThan(4887L))
		.header("Content-Type", "application/json")
		.assertThat().body("authenticated", oneOf(true, false))
		.log().body();
		
		
	}
}
