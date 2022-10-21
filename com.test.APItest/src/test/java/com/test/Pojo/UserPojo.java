package com.test.Pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserPojo {
	// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
	// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
	/* ObjectMapper om = new ObjectMapper();
	Root[] root = om.readValue(myJsonString, Root[].class); */
	
	    @JsonProperty("id") 
	    public int getId() { 
			 return this.id; } 
	    public void setId(int id) { 
			 this.id = id; } 
	    int id;
	    @JsonProperty("employee_name") 
	    public String getEmployee_name() { 
			 return this.employee_name; } 
	    public void setEmployee_name(String employee_name) { 
			 this.employee_name = employee_name; } 
	    String employee_name;
	    @JsonProperty("employee_salary") 
	    public int getEmployee_salary() { 
			 return this.employee_salary; } 
	    public void setEmployee_salary(int employee_salary) { 
			 this.employee_salary = employee_salary; } 
	    int employee_salary;
	    @JsonProperty("employee_age") 
	    public int getEmployee_age() { 
			 return this.employee_age; } 
	    public void setEmployee_age(int employee_age) { 
			 this.employee_age = employee_age; } 
	    int employee_age;
	    @JsonProperty("profile_image") 
	    public String getProfile_image() { 
			 return this.profile_image; } 
	    public void setProfile_image(String profile_image) { 
			 this.profile_image = profile_image; } 
	    String profile_image;
	}





