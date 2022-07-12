package com.chainsys.mavenlessons.entity;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;
@Entity
@Table(name="Doctor")
public class Doctor {
	@Id
	@Column(name="doctor_Id")
	private int id ;
	@Column(name="doctor_name")
	private String doctor_name;
	@Column(name="dob")
	private Date dob  ;
	@Column(name="speciality")
	private String speciality ;
	@Column(name="city")
	private String city  ;
	@Column(name="phoneno")
	private long phoneno  ;
	@Column(name="standard_fees")
	private int standard_fees ;
	//Bidirectional Association
//each doctor can have one or more appointments so the list is used	
	@OneToMany(mappedBy="doctor",fetch=FetchType.LAZY)//only needed object is loaded using LAZY
	@JsonIgnore
	private List<Appointment>appointments;
	public List<Appointment>getAppointments(){
		return this.appointments;
	}
	public int getDoc_Id() {
		return id;
	}
	public void setDoc_Id(int doc_Id) {
		this.id = doc_Id;
	}
	public String getDoc_name() {
		return doctor_name;
	}
	public void setDoc_name(String doc_name) {
		this.doctor_name = doc_name;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public long getPhonenumber() {
		return phoneno;
	}
	public void setPhonenumber(long phonenumber) {
		this.phoneno = phonenumber;
	}
	public int getStandard_fees() {
		return standard_fees;
	}
	public void setStandard_fees(int standard_fees) {
		this.standard_fees = standard_fees;
	}
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %s, %d",id,doctor_name,dob,city,phoneno);
	}

}
