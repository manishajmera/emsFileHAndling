package com.girnarsoft.employees;

/*
 * base class for all employees 
 */
public class Employee {
    protected int empId;
	protected String name, password, designation;
	protected int supervisedBy;

	public int getSupervisedBy() {
		return supervisedBy;
	}

	public void setSupervisedBy(int supervisedBy) {
		this.supervisedBy = supervisedBy;
	}

	public Employee(int empId, String name, String password, String designation, int supervisedBy) {

		this.empId = empId;
		this.name = name;
		this.password = password;
		this.designation = designation;
		this.supervisedBy = supervisedBy;
	}

	public int getId() {
		return empId;
	}

	public void setId(int empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
