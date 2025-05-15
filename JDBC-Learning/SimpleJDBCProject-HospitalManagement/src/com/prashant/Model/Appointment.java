package com.prashant.Model;

import java.util.Date;
import java.util.Objects;

public class Appointment {
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private Date appointmentStartTime;
	private Date appointmentEndTime;
	
	public int getAppointmentId() {
		return appointmentId;
	}
	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public int getDoctorId() {
		return doctorId;
	}
	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}
	public Date getAppointmentStartTime() {
		return appointmentStartTime;
	}
	public void setAppointmentStartTime(Date appointmentStartTime) {
		this.appointmentStartTime = appointmentStartTime;
	}
	public Date getAppointmentEndTime() {
		return appointmentEndTime;
	}
	public void setAppointmentEndTime(Date appointmentEndTime) {
		this.appointmentEndTime = appointmentEndTime;
	}
	
	
	
	
}
