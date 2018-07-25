package com.girnarsoft.employees;

import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;
/*
 * here Hr funtionalities like addEmployee as trainee and manager , 
 * delete employee from database , or promotion funtionalities
 */

public class HrServices implements Services {
	Scanner sc = new Scanner(System.in);
	Checkers checkers = new Checkers();

	/*
	 * add employee into stored Data
	 */
	public void addEmployee(Map<Integer, Employee> employees, String empDesignation, int empId) {

		String empName, empPassword;
		System.out.println("Enter employee name to be added");
		empName = sc.nextLine();
		empName = checkers.validateString(empName);
		System.out.println("Enter password of employee");
		empPassword = sc.nextLine();
		while(empPassword.isEmpty())
		{
			System.out.println("Password can't be blank");
			System.out.println("Enter password of employee");
			empPassword = sc.nextLine();
			
		}
		int mentor;
		System.out.println("Enter superviser id");
		mentor = Integer.parseInt(checkers.validateInt(sc.nextLine()));

		if (empDesignation.equals("Trainee")) {
			while (!employees.containsKey(mentor)||employees.get(mentor).getDesignation().equals("Trainee")) {
				System.out.println("Mentor not exsit in dataBase or you can't assign it! try again");
				mentor = Integer.parseInt(checkers.validateInt(sc.nextLine()));

			}
		} else if (empDesignation.equals("Manager")) {
			while ( !employees.containsKey(mentor)||employees.get(mentor).getDesignation().equals("Manager") ||
					 employees.get(mentor).getDesignation().equals("Trainee")) {
				System.out.println("Mentor not exsit in dataBase or you can't assign it! try again");
				mentor = Integer.parseInt(checkers.validateInt(sc.nextLine()));
			}

		} else if (empDesignation.equals("Director")) {

			while (!employees.containsKey(mentor) || employees.get(mentor).getDesignation().equals("Manager")
					|| employees.get(mentor).getDesignation().equals("Trainee")
					|| employees.get(mentor).getDesignation().equals("Director")) {
				System.out.println("Mentor not exsit in dataBase or you can't assign it! try again");
				mentor = Integer.parseInt(checkers.validateInt(sc.nextLine()));
			}

		}

		Employee newEmployee = new Employee(empId, empName, empPassword, empDesignation, mentor);
		employees.put(empId, newEmployee);
	}

	/*
	 * promote employees from trainee to manager are in this method
	 */
	public void promote(Map<Integer, Employee> employees) {
		System.out.println("Enter employee id you want to promote");
		int empId3 = Integer.parseInt(checkers.validateInt(sc.nextLine()));
		while (!employees.containsKey(empId3)) {
			System.out.println("Please enter valid id");
			empId3 = Integer.parseInt(checkers.validateInt(sc.nextLine()));

		}
		Employee emp = employees.get(empId3);
		if ((!employees.containsKey(empId3)) || (emp.getDesignation().equals("Director")
				|| emp.getDesignation().equals("HR") || emp.getDesignation().equals("CEO"))) {
			System.out.println(
					"please type correct id or this employee is already at higher position or at same position that u want to promote.");
		} else
			emp.setDesignation("Manager");
	}

	/*
	 * Delete employee from database are in this method
	 */
	public void deleteEmployee(Map<Integer, Employee> employees, int empId) {
		employees.remove(empId);
		for (Entry<Integer, Employee> entry : employees.entrySet()) {
			if (entry.getKey() == empId) {
				employees.get(empId).setSupervisedBy(-1);
			}
		}
	}
	/*
	 * (non-Javadoc)
	 * @see com.girnarsoft.employees.Services#showEmployeesUnderMe(java.util.Map, int)
	 * method use for showing employeed under Hr and Ceo
	 */
	public void showEmployeesUnderMe(Map<Integer, Employee> employees, int empId) {
		System.out.println("Employees in my Team");
		for (Entry<Integer, Employee> entry : employees.entrySet()) {
			if (employees.get(entry.getKey()).getSupervisedBy() == empId) {
				System.out
						.println(employees.get(entry.getKey()).getId() + " " + employees.get(entry.getKey()).getName());
			}
		}
	}

}
