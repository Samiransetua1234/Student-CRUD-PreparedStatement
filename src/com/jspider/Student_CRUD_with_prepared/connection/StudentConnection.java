package com.jspider.Student_CRUD_with_prepared.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class StudentConnection {
	public static Connection getStudentConnection() {

		try {
			// step1 load/register driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// step2 create connection

			String url = "jdbc:mysql://localhost:3306/jdbc_preparedstatement";
			String user = "root";
			String pass = "root1234";

			Connection connection = DriverManager.getConnection(url, user, pass);

			return connection;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
}
