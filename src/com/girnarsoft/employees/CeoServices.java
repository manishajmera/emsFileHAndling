package com.girnarsoft.employees;

import java.util.Map;
import java.util.Scanner;

/*
 * this method extends hr so all the funtionalities of hr are inherited here
 * and promotion funtionalitie is override so ceo can promote manager to director
 */
public class CeoServices extends HrServices implements Services {
	Scanner sc = new Scanner(System.in);
	Checkers checkers = new Checkers();

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.girnarsoft.employees.HrServices#promote(java.util.Map) promotion
	 * method
	 */
	public void promote(Map<Integer, Employee> employees) {
		System.out.println("Enter employee id you want to promote");
		int empId1 = Integer.parseInt(checkers.validateInt(sc.nextLine()));
		while (!employees.containsKey(empId1)) {
			System.out.println("Please enter valid id");
			empId1 = Integer.parseInt(checkers.validateInt(sc.nextLine()));

		}

		if (employees.get(empId1).getDesignation().equals("Trainee")) {
			System.out.println("Do you want to promote this employee type Y/N");
			String check = sc.nextLine();
			while (!check.equals("Y")) {
				System.out.println("please type valid input");
				check = sc.nextLine();
			}
			if (check.equals("Y")) {
				employees.get(empId1).setDesignation("Manager");

			}
		} else if (employees.get(empId1).getDesignation().equals("Manager")) {
			System.out.println("Do you want to promote this employee type Y/N");
			String check = sc.nextLine();
			while (!check.equals("Y")) {
				System.out.println("please type valid input");
				check = sc.nextLine();
			}
			if (check.equals("Y")) {
				employees.get(empId1).setDesignation("Director");

			}
		} else {
			System.out.println("please type valid input id or employee is already at higher position");
			promote(employees);
		}
	}

}
