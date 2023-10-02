package com.reusable;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class Reusable {
	RequestSpecification reqSpec;

	Response response;

	public void addHeader(String key, String value) {
		reqSpec=RestAssured.given().header(key, value);
	}
	public void addHeaders(Headers headers) {
		reqSpec=RestAssured.given().headers(headers);

	}
	public void queryParameter(String key,String value) {
		reqSpec=reqSpec.queryParam(key, value);
	}
	public void pathParameter(String key,String value) {
		reqSpec=reqSpec.queryParam(key, value);
	}
	public void addBody(String body) {
		reqSpec=reqSpec.body(body);
	}
	public void addBody(Object body) {
		reqSpec=reqSpec.body(body);
	}
	public void basicAuth(String userName,String password) {
		reqSpec.auth().preemptive().basic(userName, password);
	}
	public void formData() {
		reqSpec = reqSpec.multiPart("Profile_Picture", new File("E:\\imag.png"));
	
	}
	
	public static String getPropertyValue(String key) throws IOException {
		Properties properties=new Properties();
		
		FileInputStream stream=new FileInputStream("C:\\Users\\PRITHIVIRAJ\\eclipse-workspace4\\Petstore\\src\\test\\resources\\Config.properties");
		properties.load(stream);
		
		Object obj=properties.get(key);
		
		String value=(String)obj;
		return value;
	}
	public Response requestType(String reqType,String endPoint) {
		switch (reqType) {
		case "GET":
			response=reqSpec.get(endPoint);

			break;
		case "POST":
			response=reqSpec.post(endPoint);

			break;
		case "PUT":
			response=reqSpec.put(endPoint);

			break;
		case "DELETE":
			response=reqSpec.delete(endPoint);

			break;
		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;
	}
	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();

		return body;

	}
	
	public String getBodyAsString(Response response) {
		String asString = getBody(response).asString();

		return asString;
	}
	public String getBodyAsPrettyString(Response response) {
		String asPrettyString = getBody(response).asPrettyString();
		return asPrettyString;
	}

}
