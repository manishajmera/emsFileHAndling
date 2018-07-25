package com.girnarsoft.employees;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
/*
 * this class show the user menu and his funtionalities
 */

public class EmsDemo {
	private static Map<Integer, Employee> empList = new HashMap<Integer, Employee>();
	private static final Scanner SC = new Scanner(System.in);
	public static int generateEmpId ;
	public static FileOperations fileOperations  = new FileOperations();
	public static Checkers checkers = new Checkers();
	//initialize HashMap Of all the Employees
	protected void init(String str) {
		String str1[] = { "", "", "", "", "" };
		int count = 0;
		for (int index = 0; index < str.length(); index++) {
			if (str.charAt(index) != ':') {
				str1[count] += str.charAt(index);
			}
			if (str.charAt(index) == ':') {
				count++;
				continue;
			}
		}
		empList.put(Integer.parseInt(str1[0]),
				new Employee(Integer.parseInt(str1[0]), str1[1], str1[2], str1[3], Integer.parseInt(str1[4])));
		generateEmpId = Integer.parseInt(str1[0])+1;
	}

//main menu functions for Hr Ceo Manager Trainee Director
	public static void main(String[] args) {
		String choice;
		String password;
		Integer empId;
		fileOperations.readFromFile();
		while (true) {
			System.out.println("Hello ! Please eneter your employee id: ");
			empId = Integer.parseInt(checkers.validateInt(SC.nextLine()));
			while(!empList.containsKey(empId))
			{
				System.out.println("Employee not exist ! try again");
				System.out.println("Hello ! Please eneter your employee id: ");
				empId = Integer.parseInt(checkers.validateInt(SC.nextLine()));
				
			}
			System.out.println("-----" + empId);
			System.out.println("Enter your Password: ");
			password = SC.nextLine();

			if (!checkers.verifyPassword(empId, password,empList)) {
				System.out.println("Please enter correct credentials try again");
				continue;
			}
			choice = empList.get(empId).getDesignation();
			switch (choice) {
			case "CEO":
				actionMenu(empId);
				break;
			case "HR":
				actionMenu(empId);
				break;
			case "Manager":
				ManagerService manager = new ManagerService();
				manager.showSupervisedManager(empList, empId);
				break;
			case "Director":
				DirectorServices director = new DirectorServices();
				director.showManagerUnderMe(empList, empId);
				break;
			default:
				TraineeServices trainee = new TraineeServices();
				trainee.showSupervisedManager(empList, empId);
				break;
			}
		}
	}
//actions of hr and ceo
	private static void actionMenu(int empId) {
		int exitFromLoop = 0;
		int choose;
		if (empId == 1) {
			System.out.println("Welcome Ceo");
		} else {
			System.out.println("Welcome Hr");
		}
		while (exitFromLoop != -1) {
			System.out.println("1. Add employee");
			System.out.println("2. Delete employee");
			System.out.println("3.Show Employees Details");
			System.out.println("4.Promotion");
			System.out.println("5.Show Employees Under Me");
			System.out.println("press any number other then this for logout");
			choose = Integer.parseInt(checkers.validateInt(SC.nextLine()));
		    Services hr = new HrServices();
			switch (choose) {
			case 1:
				
				while(true) {
					System.out.println("Choose Designation");
					System.out.println("1.Add Trainee 2. Add Manager 3. Add Director");
					int designation = Integer.parseInt(new Checkers().validateInt(SC.nextLine()));

				if (designation == 1) {
					hr.addEmployee(empList, "Trainee", generateEmpId);
					System.out.println("Trainee added successfully ! with employee id" + generateEmpId);
					generateEmpId++;
					break;
				} else if (designation == 2) {
					hr.addEmployee(empList, "Manager", generateEmpId);
					System.out.println("Manager added successfully ! with employee id: " + generateEmpId);
					generateEmpId++;
					break;
				} else if (empId == 1 && designation == 3) {
					hr.addEmployee(empList, "Director", generateEmpId);
					System.out.println("Director added successfully ! with employee id: " + generateEmpId);
					generateEmpId++;
					break;
				} else {
					System.out.println("Wrong Input! try again");
					continue;
				}
				
			}
				fileOperations.copyToFile(empList);
				break;
			case 2:
				System.out.println("Enter employee id you want to remove");
				int employeeRemoveId = Integer.parseInt(checkers.validateInt((SC.nextLine())));
				if (!empList.containsKey(employeeRemoveId)) {
					System.out.println("please type correct id");
				} else {
					hr.deleteEmployee(empList, employeeRemoveId);
					fileOperations.copyToFile(empList);
				}
				break;
			case 3:
				System.out.println("Employees________");
				for (Entry<Integer, Employee> entry : empList.entrySet()) {
					System.out.println(entry.getKey() + " " + empList.get(entry.getKey()).getName() + " "
							+ empList.get(entry.getKey()).getDesignation() + " "
							+ empList.get(entry.getKey()).getSupervisedBy());
				}
				System.out.println("_________");
				break;
			case 4:
				if (empId == 1) {
					Services ceo = new CeoServices();
					ceo.promote(empList);
				} else
					hr.promote(empList);
				break;
			case 5:
				if(empId==1)
				{
					Services ceo = new CeoServices();
					ceo.showEmployeesUnderMe(empList, empId);
				}
				else {
					hr.showEmployeesUnderMe(empList, empId);
				}
				break;	
			default:
				System.out.println("Log Out -----");
				exitFromLoop = -1;
			}
		}
	}
}
