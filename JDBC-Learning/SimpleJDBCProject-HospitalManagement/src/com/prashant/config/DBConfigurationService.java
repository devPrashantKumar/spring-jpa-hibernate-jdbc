package com.prashant.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConfigurationService {
	private static Connection conn;
	
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospitalManagement", "root", "root");
		System.out.println("DB Connection Created");
		return conn;
	}
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		if(conn==null) return createConnection();
		return conn;
	}
}
