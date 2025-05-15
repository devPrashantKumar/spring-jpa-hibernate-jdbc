package com.prashant.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.prashant.Model.Appointment;
import com.prashant.Model.Patient;

public class AppointmentService {
	private Connection conn;

	public AppointmentService(Connection conn) {
		this.conn = conn;
	}
	
	public void bookAppointment() throws SQLException {
		Appointment appointment = new Appointment();
		String query = "insert into appointment(patientId,doctorId,appointmentStartTime,appointmentEndTime) values (?,?,?,?)";
		try (Scanner sc = new Scanner(System.in);
				PreparedStatement ps = conn.prepareStatement(query)) {
			System.out.print("PatientId : ");
			appointment.setPatientId(Integer.parseInt(sc.nextLine()));
			ps.setInt(1, appointment.getPatientId());
			System.out.print("DoctorId : ");
			appointment.setDoctorId(Integer.parseInt(sc.nextLine()));
			ps.setInt(2, appointment.getDoctorId());
			String appointmentStartTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	        ps.setString(3, appointmentStartTime);
	        long endTimeInMillis = System.currentTimeMillis() + (30 * 60 * 1000); // 30 minutes later
	        String appointmentEndTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(endTimeInMillis));
	        ps.setString(4, appointmentEndTime);
			ps.executeUpdate();
		}
	}
}
