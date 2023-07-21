package com.jspider.Student_CRUD_with_prepared.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.jspider.Student_CRUD_with_prepared.connection.StudentConnection;
//import com.jspider.Student_CRUD_with_prepared.dao.StudentDao;
import com.jspider.Student_CRUD_with_prepared.dto.Student;
import com.jspider.Student_CRUD_with_prepared.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		while(true){
			
			
			System.out.println("Please select what operation you want to perform \n"
					+ "Enter 1 for insert new student\n"
					+ "Enter 2 for update student data\n"
					+ "Enter 3 for delete student data\n"
					+ "Enter 4 for display all students\n"
					+ "Enter 5 to close the application");
			int x = scanner.nextInt();
			if(x == 5) {
				Connection connection = StudentConnection.getStudentConnection();
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Than You for Visiting Us !!!");
				break;
			}
			switch(x) {
				case 1:{
					
					System.out.println("Enter Studen Id ");
					int sid = scanner.nextInt();
					System.out.println("Enter Student Name");
					String sname = scanner.next();
					System.out.println("Enter Student Email ");
					String semail = scanner.next();
					System.out.println("Enter Student Phone number");
					long sphone = scanner.nextLong();
					Student student = new Student(sid, sname, semail, sphone);
					
					StudentService service = new StudentService();
					
					service.insertStudentService(student);
					System.out.println("Data inserted successfully!!!");
					break;
				}
				case 2:{
					System.out.println("Enter the studen Id you want to update ");
					int sid = scanner.nextInt();
					System.out.println("Enter new email Id");
					String semail = scanner.next();
					Student student = new Student();
					student.setsEmail(semail);
					student.setsId(sid);
					StudentService service = new StudentService();
					
					service.updateStudentService(student);
					break;
				}
				case 3:{
					System.out.println("Enter Student Id which you want to delete !!!");
					
					int id = scanner.nextInt();
					
					Student student = new Student();
					
					student.setsId(id);
					
					StudentService service = new StudentService();
					service.deleteStudentService(student);
					break;
				}
				case 4:{
					System.out.println("Student display!!!");
					StudentService service = new StudentService();
					service.displayAllStudentsService();
					break;
				}
				default :{
					System.err.println("Please Enter valid option");
				}
			}
			
			
			
		}

		
		
	}
}
