package com.prashant;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.prashant.config.DBConfigurationService;
import com.prashant.service.AppointmentService;
import com.prashant.service.DoctorService;
import com.prashant.service.PatientService;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		try (Connection connection = DBConfigurationService.getConnection(); Scanner sc = new Scanner(System.in);) {
			System.out.println("Welcome to Hospital Management System");
			PatientService patientService = new PatientService(connection);
			DoctorService doctorService = new DoctorService(connection);
			AppointmentService appointmentService = new AppointmentService(connection);
			
			while (true) {
				System.out.println("Please select operation you want to perform");
				System.out.println("1 : Add Patient");
				System.out.println("2 : Add Doctor");
				System.out.println("3 : Book Appointment");
				System.out.println("4 : Exit");
                int selectedOperation = Integer.parseInt(sc.nextLine());
                
				switch (selectedOperation) {
				case 1:
					patientService.addPatient();
					break;
				case 2:
					doctorService.addDoctor();
					break;
				case 3:
					appointmentService.bookAppointment();
					break;
				case 4:
					System.exit(0);
					break;
				}
			}

		}

	}

}
