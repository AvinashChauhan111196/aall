package com.maveric.project.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeePojo {
 
	public String name,salary,age;
	public EmployeePojo() {
    }
 
	 @JsonCreator
	    public EmployeePojo(@JsonProperty("employee_name")  String name, 
	                        @JsonProperty("employee_salary") String salary, 
	                        @JsonProperty("employee_age") String age)
	    {
	        this.name = name;
	        this.salary = salary;
	        this.age = age;
	    }
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getSalary() {
		return salary;
	}
 
	public void setSalary(String salary) {
		this.salary = salary;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
}