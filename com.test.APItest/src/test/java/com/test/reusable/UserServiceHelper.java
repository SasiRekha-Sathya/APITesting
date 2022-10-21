package com.test.reusable;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.Pojo.AddUserpojo;
import com.test.Pojo.LoginRequestPOJO;
import com.test.Pojo.UserPojo;
import com.test.utils.Utils;
import com.tests.constants.Endpoints;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserServiceHelper {
	private static Response response;
	private static String token = null;
	public static Utils util = null;

	@BeforeTest
	public static void SetUp() throws IOException {
		util = new Utils();
		RestAssured.baseURI = util.getProperty("BaseUrl");
	}

	public static Response Logintoapp() {
		String username = util.getProperty("username");
		String password = util.getProperty("password");
		LoginRequestPOJO ob = new LoginRequestPOJO();
		ob.setUsername(username);
		ob.setPassword(password);
		response = RestAssured.given().contentType("application/json").body(ob).when().post(Endpoints.LOGIN);
		return response;

	}

	public static String token() {
		response = Logintoapp();
		token = response.jsonPath().getString("[0].token");
		return token;
	}

	public static List<UserPojo> getUserData() throws JsonMappingException, JsonProcessingException {
		// Header header = new Header("token", token);
		// System.out.println("User data token =" + token);
		System.out.println(RestAssured.baseURI);
		response = RestAssured.given().contentType("application/json").when().get(Endpoints.GET_DATA);
		System.out.println(response.asPrettyString());
		ObjectMapper om = new ObjectMapper();
		List<UserPojo> list = response.getBody().jsonPath().get("data");
		System.out.println(list.toString());
		// UserPojo[] userArray= om.readValue(data_json, UserPojo[].class);
		// List<UserPojo> list = Arrays.asList(userArray);
		response.then().statusCode(200);
		System.out.println("Number of records =" + response.getBody().jsonPath().get("data.size()"));
		return list;
	}

	public static Response addUserData(AddUserpojo user) {
		// Header header = new Header("token", token);
		System.out.println(RestAssured.baseURI);
		response = RestAssured.given().contentType(ContentType.JSON).body(user).when().post(Endpoints.ADD_DATA);
		return response;

	}

	public static int getStatusCode(Response res) {
		return res.getStatusCode();
	}

	/*
	 * public static Response UpDateUserData() { UserPojo updateUser = new
	 * UserPojo(); List<UserPojo> listofUsers = getUserData(); for (UserPojo
	 * usertobeupdated : listofUsers) { //if
	 * (usertobeupdated.getAccountno().equals(ReusableMethod.user.getAccountno())) {
	 * updateUser=usertobeupdated; // updateUser.setDepartmentno("5");
	 * 
	 * } } return response; }
	 * 
	 * public static Response DeleteUserData1() { UserPojo deleteUser = new
	 * UserPojo(); List<UserPojo> listofUsers = getUserData(); for (UserPojo
	 * usertobedeleted : listofUsers) { if
	 * (usertobedeleted.getAccountno().equals(ReusableMethod.user.getAccountno())) {
	 * deleteUser=usertobedeleted; deleteUser.setSalary("8000"); }}
	 */

	// return response;

	// }

	private static void DeleteUserData() {
		// TODO Auto-generated method stub

	}
}
