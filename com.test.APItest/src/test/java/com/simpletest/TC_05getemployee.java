package com.simpletest;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.reusable.ReusableMethod;
import com.test.reusable.UserServiceHelper;
import com.tests.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_05getemployee extends UserServiceHelper {
	@Test
	public static void getusermethod() throws JsonMappingException, JsonProcessingException {
		Response response = RestAssured.given().contentType("application/json").when()
				.get(Endpoints.GET_EMPLOYEE + "/2");
		response.then().body("status", Matchers.equalTo("success"));
		ReusableMethod.VerifyJsonPath(response, "data.employee_name", "Garrett Winters");
		ReusableMethod.VerifyJsonPathInt(response,"data.employee_salary", 170750);
		ReusableMethod.VerifyJsonPathInt(response, "data.employee_age", 63);
	}
}