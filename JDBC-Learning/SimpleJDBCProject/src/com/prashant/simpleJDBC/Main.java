package com.prashant.simpleJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

import com.prashant.simpleJDBC.config.DBConfigurationService;

public class Main {

	public static void main(String[] args) {

		try (Connection connection = DBConfigurationService.getConnection(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Welcome to School Management System");

			// select using create statement.
			Statement statement = connection.createStatement();
			String query = "select * from student";
			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()){
				System.out.println("id : "+resultSet.getInt("id"));
				System.out.println("name : "+resultSet.getString("name"));
				System.out.println("age : "+resultSet.getInt("age"));
				System.out.println("marks : "+resultSet.getDouble("marks"));
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}

	}

}
