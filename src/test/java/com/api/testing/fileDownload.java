package com.api.testing;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import com.github.javafaker.File;
import io.restassured.response.Response;
import java.io.IOException;

public class fileDownload {
	
	@Test
	
	public void fileDownloadFunction() {
		
		
		Response response = given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 2ebfdff01a7c18c4e7444f80fa5ef2053e017a333cfbca9b8a2bcc8f4911de34")
		
		.when()
		.get("https://gorest.co.in/public/v2/users")
		.thenReturn();
		
		System.out.println("Response Code ; "+response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), 200);
		
		byte[] responseBytes = response.getBody().asByteArray();
		
		File file = new File("C:\\Users\\Public\\getResponse.json");
		Files.write(file.toPath(), responseBytes);
		
		
		
	}

}
