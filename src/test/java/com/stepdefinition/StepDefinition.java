package com.stepdefinition;

import org.junit.Assert;

import com.payload.Payloads;
import com.pojo.Create_User;
import com.pojo.Create_User_Output;
import com.pojo.Update_User;
import com.pojo.Update_User_Output;
import com.reusable.Endpoints;
import com.reusable.Reusable;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class StepDefinition extends Reusable{

	Payloads payloads;
	Response response;
	Create_User_Output create_user_output;
	//createuser
	@Given("User add header information for create user")
	public void user_add_header_information_for_create_user() {
		addHeader("Content-Type", "application/json");
	}
	@When("User add payload for user creation {string},{string}, {string},{string},{string},{string},{string},{string}")
	public void user_add_payload_for_user_creation(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		Integer userId = Integer.valueOf(string);
		Integer userStatus = Integer.valueOf(string8);
		
		Create_User createUser = payloads.createUser(userId, string2, string3, string4, string5, string6, string7, userStatus);
		addBody(createUser);
	}
	@When("User send {string} request to creatuser endpoint")
	public void user_send_request_to_creatuser_endpoint(String string) {
		response= requestType(string, Endpoints.CREATEUSER);
	}
	@When("User verify the status code is {int}")
	public void user_verify_the_status_code_is(Integer int1) {
		int statusCode=int1;
		 int actualCode = response.getStatusCode();
		Assert.assertEquals("verify status code",statusCode,actualCode);  
	}
	@Then("User verify created user")
	public void user_verify_created_user() {
		Create_User_Output user_Output = response.as(Create_User_Output.class);
		String firstName = user_Output.getFirstName();
		Assert.assertEquals("verify first Name",firstName,"Prithiviraj");  
	}

	
	//UpdateUser
	@Given("User add header information for update user")
	public void user_add_header_information_for_update_user() {
		addHeader("Content-Type", "application/json");
	}
	@When("User add payload for user updation {string},{string}, {string},{string},{string},{string},{string},{string}")
	public void user_add_payload_for_user_updation(String string, String string2, String string3, String string4, String string5, String string6, String string7, String string8) {
		Integer updateUserId = Integer.valueOf(string);
		Integer UpdateUserStatus = Integer.valueOf(string8);
		Update_User updateUser=new Update_User(updateUserId, string2, string3, string4, string5, string6, string7, UpdateUserStatus);
		addBody(updateUser);
	}
	@When("User send {string} request to update user endpoint")
	public void user_send_request_to_update_user_endpoint(String string) {
		response= requestType(string, Endpoints.UPDATEUSER);
	}
	@When("User verify the status code of {int}")
	public void user_verify_the_status_code_of(Integer int1) {
		int statusCode=int1;
		int actualCode = response.getStatusCode();
		Assert.assertEquals("verify status code",statusCode,actualCode); 
	}
	@Then("User verify updation of user")
	public void user_verify_updation_of_user() {
		Update_User_Output update_User_Output = response.as(Update_User_Output.class);
		String firstName = update_User_Output.getFirstName();
		Assert.assertEquals("verify first Name",firstName,"Elangovan"); 
	}
	
	
	//DeleteUser
	@Given("User add headers to delete user")
	public void user_add_headers_to_delete_user() {
		addHeader("Content-Type", "application/json");
	}
	@When("User send {string} request and deleteuser endpoint")
	public void user_send_request_and_deleteuser_endpoint(String string) {
		response= requestType(string, Endpoints.DELETEUSER);
	}
	@When("User verify the status code is {int} status code")
	public void user_verify_the_status_code_is_status_code(Integer int1) {
		int statusCode=int1;
		int actualCode = response.getStatusCode();
		Assert.assertEquals("verify status code",statusCode,actualCode); 
	}
	@Then("User should verify {string} message")
	public void user_should_verify_message(String string) {
		
	}






}
