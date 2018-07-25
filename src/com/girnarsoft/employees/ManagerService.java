package com.girnarsoft.employees;

import java.util.Map;
import java.util.Map.Entry;

/**
 * Trainee under manager and other manager funtionalities are in this class
 */
public class ManagerService extends TraineeServices {
	public void showTraineeUnderMe(Map<Integer, Employee> employees, int empId) {
		System.out.println("Welcome Manager");
		System.out.println("Trainee Under me");
		for (Entry<Integer, Employee> entry : employees.entrySet()) {
			if (employees.get(entry.getKey()).getSupervisedBy() == empId) {
				System.out
						.println(employees.get(entry.getKey()).getId() + " " + employees.get(entry.getKey()).getName()+"\n");
			}
		}
	}
}
