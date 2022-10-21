package com.test.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/*//import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class AddUserpojo {
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/*
	 * ObjectMapper om = new ObjectMapper(); Root root = om.readValue(myJsonString,
	 * Root.class);
	 */
	@JsonProperty("name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	String name;

	@JsonProperty("salary")
	public String getSalary() {
		return this.salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	String salary;

	@JsonProperty("age")
	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	String age;
}
