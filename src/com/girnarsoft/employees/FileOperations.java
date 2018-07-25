package com.girnarsoft.employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

/**
 * all the file operations methods are in this class
 */
public class FileOperations {
	// Copy Data from HashMap to file employee.txt
	protected void copyToFile(Map<Integer, Employee> empList) {
		FileWriter fileWriter;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter("employees.txt");
			printWriter = new PrintWriter(fileWriter);
			for (Entry<Integer, Employee> entry : empList.entrySet()) {
				printWriter.println(entry.getKey() + ":" + empList.get(entry.getKey()).getName() + ":"
						+ empList.get(entry.getKey()).getPassword() + ":" + empList.get(entry.getKey()).getDesignation()
						+ ":" + empList.get(entry.getKey()).getSupervisedBy());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			printWriter.close();
		}
	}

	// read from file the data of employee and put into hashmap
	protected void readFromFile() {

		BufferedReader bufferedReader = null;
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("employees.txt");
			bufferedReader = new BufferedReader(fileReader);
			String sCurrentLine;
			while ((sCurrentLine = bufferedReader.readLine()) != null) {
				new EmsDemo().init(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null)
					bufferedReader.close();
				if (fileReader != null)
					fileReader.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
