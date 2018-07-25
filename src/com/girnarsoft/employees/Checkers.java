package com.girnarsoft.employees;

import java.util.Map;
import java.util.Scanner;

/*
 * Checkers class is used for checking 
 * that users enter integer value in empId and String name checker
 * authenticate user through his employeeId and password
 */
public class Checkers {
	/*
	 * validate that users enter valid integer
	 * 
	 */
	public static final Scanner SC = new Scanner(System.in);

	protected String validateInt(String str) {
		if (str.isEmpty()) {
			System.out.println("Wrong Input! try again");
			str = validateInt(SC.nextLine());
		} else {
			for (int index = 0; index < str.length(); index++) {
				// System.out.println(str.charAt(i)+ " ");
				if (str.charAt(index) >= '1' && str.charAt(index) <= '9' && str.charAt(index) != '0') {
					continue;
				}
				System.out.println("Wrong Input! try again ");
				str = validateInt(SC.nextLine());

			}
		}
		if (str.length() > 6) {
			System.out.println("Integer out of bound error or empId is not in range!");
			str = validateInt(SC.nextLine());
		}
		return str;
	}

	/*
	 * check credentials
	 * 
	 */
	protected boolean verifyPassword(int empId, String enteredPassword, Map<Integer, Employee> empList) {
		if (empList.get(empId) != null && empList.get(empId).getPassword().equals(enteredPassword)) {
			return true;
		} else
			return false;
	}

	/*
	 * validate Name to be of right format
	 */
	protected String validateString(String name) {
		String regex = "^[a-zA-Z]+$";
		if (!name.matches(regex)) {
			System.out.println("Wrong input ! try again");
			name = validateString(SC.nextLine());
		}
		return name;

	}

}
