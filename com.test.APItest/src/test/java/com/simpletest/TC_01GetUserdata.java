package com.simpletest;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.test.Pojo.UserPojo;
import com.test.reusable.UserServiceHelper;

public class TC_01GetUserdata extends UserServiceHelper {
	

	@Test
	public static void getusermethod() throws JsonMappingException, JsonProcessingException {
		List<UserPojo> listofusers = getUserData();

	}
}
