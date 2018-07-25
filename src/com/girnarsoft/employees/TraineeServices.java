package com.girnarsoft.employees;

import java.util.Map;
/*
 * trainee services functions are in this class
 */

public class TraineeServices {
	protected void showSupervisedManager(Map<Integer, Employee> employees, int empId) {
		System.out.println("Welcome Trainee");
		Employee trainee = employees.get(empId);
		if (trainee.getSupervisedBy() == -1) {
			System.out.println("currently this trainee has no supervisor");
		} else
			System.out.println("Your supervised manager is :-  " + " " + trainee.getSupervisedBy() + " "
					+ employees.get(trainee.getSupervisedBy()).getName());
	}
}
