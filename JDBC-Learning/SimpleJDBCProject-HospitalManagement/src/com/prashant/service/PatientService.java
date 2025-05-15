package com.prashant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.prashant.Model.Patient;

public class PatientService {
	private Connection conn;

	public PatientService(Connection conn) {
		this.conn = conn;
	}

	public boolean addPatient() throws SQLException {
		Patient patient = new Patient();
		String query = "insert into patient(patientName) values (?)";
		try (Scanner sc = new Scanner(System.in);
				PreparedStatement ps = conn.prepareStatement(query)) {
			System.out.print("PatientName : ");
			patient.setPatientName(sc.nextLine());
			ps.setString(1, patient.getPatientName());
			ps.execute();
		}
		return true;
	}
}
