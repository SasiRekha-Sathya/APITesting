package com.simpletest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.test.Pojo.AddUserpojo;
import com.test.reusable.ReusableMethod;
import com.test.reusable.UserServiceHelper;
import com.tests.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_02CreateDeleteUserdata extends UserServiceHelper {
	public static int id;
	@Test
	public static void adduserdetails() {
		AddUserpojo user = ReusableMethod.getUserDatatoAdd();
//		System.out.println(user.getAge());
		Response response = addUserData(user);
		id=response.getBody().jsonPath().get("data.id");
		System.out.println(id);
		ReusableMethod.VerifyStatuscode(response, 200);
		//String Status = response.jsonPath().get("status");
		System.out.println(response.asPrettyString());
		ReusableMethod.VerifyJsonPath(response, "data.salary", user.getSalary());
		ReusableMethod.VerifyJsonPath(response, "data.name", user.getName());
		ReusableMethod.VerifyJsonPath(response, "data.age", user.getAge());
		response.then().body("status", Matchers.equalTo("success"));
	}
	
	@Test
	public static void deleteuser() {
		Response response = RestAssured.given().contentType("application/json").when()
				.delete(Endpoints.DELETE_DATA+"/"+id);
		System.out.println(id);
		response.then().body("status", Matchers.equalTo("success"));
	}
	@Test
	public static void deleteuser2() {
		Response response = RestAssured.given().contentType("application/json").when()
				.delete(Endpoints.DELETE_DATA+"/0");
		System.out.println(id);
		response.then().body("status", Matchers.equalTo("error"));
	}
}