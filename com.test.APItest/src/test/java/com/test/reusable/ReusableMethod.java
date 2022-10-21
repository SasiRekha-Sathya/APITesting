package com.test.reusable;

import java.util.concurrent.TimeUnit;

import org.hamcrest.Matchers;

import com.test.Pojo.AddUserpojo;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ReusableMethod {
	public static AddUserpojo user;
	public static AddUserpojo getUserDatatoAdd() {
		user=new AddUserpojo();
		user.setName("test");
		user.setSalary("123");
		user.setAge("23");
		return user;
	}
	public int getStatuscode(Response response) {
		return response.getStatusCode();
	}
	public String ContentType(Response response) {
		return response.contentType();
	}
	public long getResponseetime(Response response, TimeUnit unit) {
		return response.getTimeIn(unit);
	}
	public static void VerifyStatuscode(Response response,int statuscode) {
		response.then().statusCode(statuscode);
	}
	public static ValidatableResponse VerifyJsonPath(Response response,String jsonpath,String value) {
		 return response.then().body(jsonpath,Matchers.equalTo(value));
	}
	
	public static ValidatableResponse VerifyJsonPathInt(Response response,String jsonpath,int value) {
		 return response.then().body(jsonpath,Matchers.equalTo(value));
	}
}
