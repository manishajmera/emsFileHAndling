package com.girnarsoft.employees;

import java.util.Map;
import java.util.Map.Entry;

/*
 * Manager under director and other director funtionalities are in this class
 */
public class DirectorServices extends ManagerService {
	protected void showManagerUnderMe(Map<Integer, Employee> employees, int empId) {

		System.out.println("Welcome Director");
		System.out.println("Managers Under Me");
		for (Entry<Integer, Employee> entry : employees.entrySet()) {
			if (employees.get(entry.getKey()).getSupervisedBy() == empId) {
				System.out
						.println(employees.get(entry.getKey()).getId() + " " + employees.get(entry.getKey()).getName());
			}
		}
	}

}
