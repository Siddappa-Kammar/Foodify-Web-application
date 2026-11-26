package com.tap.util;

import java.sql.*;

public class DBConnection {
	
	private static final String URL = "jdbc:mysql://localhost:3306/food_app";
	private static final String NAME = "root";
	private static final String PASSWORD = "Siddu@2003";
	private static Connection connection = null;

	public static Connection getConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			connection = DriverManager.getConnection(URL, NAME, PASSWORD);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
}
