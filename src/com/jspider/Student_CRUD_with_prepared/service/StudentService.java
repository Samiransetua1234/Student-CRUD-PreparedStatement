package com.jspider.Student_CRUD_with_prepared.service;

import com.jspider.Student_CRUD_with_prepared.dao.StudentDao;
import com.jspider.Student_CRUD_with_prepared.dto.Student;

public class StudentService {
	
	StudentDao dao = new StudentDao();
	/*
	 * Student insert method to insert new student
	 */
	public Student insertStudentService (Student student) {
		
		if(student.getsId()>=1000&&student.getsId()<=9999) {
			return dao.insertStudent(student);
		}else {
			System.err.println("Please enter Student Id of 4 Digits");
		}
		
		return null;
	}
	/*
	 * Student update method to update student email by student id
	 */
	public Student updateStudentService(Student student) {
		
		
		return dao.updateStudent(student);
	}
	/*
	 * Student display method to display all students
	 */
	public void displayAllStudentsService() {
		
		
		dao.displayAllStudents();
	}
	/*
	 * Student delete method to delete student from database by student id
	 */
	public Student deleteStudentService(Student student) {
		
		
		return dao.deleteStudent(student);
	}
}
