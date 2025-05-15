package com.prashant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.prashant.Model.Doctor;

public class DoctorService {
	private Connection conn;
	
	
	public DoctorService(Connection conn) {
		this.conn = conn;
	}


	public boolean addDoctor() throws SQLException {
		Doctor doctor = new Doctor();
		String query = "insert into doctor(doctorName) values (?)";

		try (Scanner sc = new Scanner(System.in);
				PreparedStatement ps = conn.prepareStatement(query)) {
			System.out.print("DoctorName : ");
			doctor.setDoctorName(sc.next());
			ps.setString(1, doctor.getDoctorName());
			ps.execute();
		}
		return true;
	}
}
