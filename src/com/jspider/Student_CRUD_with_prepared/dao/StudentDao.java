
package com.jspider.Student_CRUD_with_prepared.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jspider.Student_CRUD_with_prepared.connection.StudentConnection;
import com.jspider.Student_CRUD_with_prepared.dto.Student;

public class StudentDao {
	/*
	 * insert method for student
	 */

	Connection connection = StudentConnection.getStudentConnection();

	public Student insertStudent(Student student) {
		/*
		 * JDBC Code
		 */
		String insertQuery = "insert into student values(?,?,?,?)";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

			preparedStatement.setInt(1, student.getsId());
			preparedStatement.setString(2, student.getsName());
			preparedStatement.setString(3, student.getsEmail());
			preparedStatement.setLong(4, student.getsPhone());

			preparedStatement.execute();

			return student;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	/*
	 * Student update method to update student email by student id
	 */
	public Student updateStudent(Student student) {
		String updateEmailQuery = "update student set semail = ? where sid = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(updateEmailQuery);
			preparedStatement.setString(1, student.getsEmail());
			preparedStatement.setInt(2, student.getsId());

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.err.println("Student data updated!!!");
				return student;
			} else {
				System.err.println("Please enter a valid Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	public void displayAllStudents() {
		String displayStudent = "select * from student";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(displayStudent);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				int id = resultSet.getInt("sid");
				String name = resultSet.getString("sname");
				String email = resultSet.getNString("semail");
				double mob = resultSet.getDouble("smob");
				System.out.println("Student Id = " + id + " Student Name = " + name + " Student Email = " + email
						+ " Student Mobile = " + mob);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Student deleteStudent(Student student) {
		String deleteStudentQuerry = "delete from student where sid = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteStudentQuerry);

			preparedStatement.setInt(1, student.getsId());

			int a = preparedStatement.executeUpdate();

			if (a == 1) {
				System.out.println("Student deleted successfully!");

			} else {
				System.err.println("Please enter a valid Id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
