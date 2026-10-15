package com.api.testing;

import static io.restassured.RestAssured.given;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.matcher.ResponseAwareMatcher;
import io.restassured.response.Response;

//import io.restassured.internal.support.FileReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
//import java.io.Reader;


public class postCreateUserusingExternalFile {
	
	@Test
	public void createUserAPI() throws FileNotFoundException {
		
		File file = new File(".\\src\\test\\resources\\payload.json"); //Locate the file
		FileReader fr = new FileReader(file);        //open+read the file
		JSONTokener jt =  new JSONTokener(fr);   //read the json files byte streams
		JSONObject requestBody = new JSONObject(jt);        //read the json file as json schema
		
		
		
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
		.log().headers()
		//.body("gender", hasItems("male","female"))
		//.body("status", hasItems("active","inactive"))
		.header("content-Type","application/json; charset=utf-8");
		//.body("name", equalTo("jjack"))
		//.time(Matchers.lessThan(2000L));
		
	}

	
	

}
