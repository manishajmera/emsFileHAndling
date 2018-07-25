package com.girnarsoft.employees;

import java.util.Map;

interface Services {
	public void addEmployee(Map<Integer, Employee> employees, String empDesignation, int superVisedId);

	public void promote(Map<Integer, Employee> employees);

	public void deleteEmployee(Map<Integer, Employee> employees, int empId);
	
	public void showEmployeesUnderMe(Map<Integer, Employee> employees, int empId);
}