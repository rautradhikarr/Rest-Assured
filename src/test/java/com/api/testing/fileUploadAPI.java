package com.api.testing;

import java.io.File;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class fileUploadAPI {
	
	@Test
	public void fileUpload() {
		
		File fileToUpload = new File("C:\\Users\\hp\\Documents\\Hello.json");
		
		Response response = given()
		.multiPart("file", fileToUpload, "multipart/form-data")
		
		.when()
		.post("https://the-internet.herokuapp.comm/upload")
		.thenReturn();
		
		System.out.println("Response Body: "+response.getStatusCode());
		System.out.println("Response Body: "+response.getBody());
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
