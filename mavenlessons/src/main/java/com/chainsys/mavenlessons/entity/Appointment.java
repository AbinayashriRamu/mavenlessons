package com.chainsys.mavenlessons.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Appointment")
public class Appointment {
	@Id
	@Column(name = "APP_ID")
	private int id;
	@Column(name = "APP_DATE")
	private Date appDate;
	@Column(name = "DOCTOR_ID")
	private int docid;
	@Column(name = "PATIENT_NAME")
	private String patname;
	@Column(name = "FEES_COLLECTED")
	private int fees;
	// @Joincolumn maps the column(doctor_id) of the current Entity appointment.
	// with the primary key column(Id) of the associated entity doctor .
//for many instances of appointment object only one instances of doctor object
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DOCTOR_ID", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Doctor doctor;
	public Doctor getDoctor() {
		return doctor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getAppDate() {
		return appDate;
	}

	public void setAppDate(Date appDate) {
		this.appDate = appDate;
	}

	public int getDocid() {
		return docid;
	}

	public void setDocid(int docid) {
		this.docid = docid;
	}

	public String getPatname() {
		return patname;
	}

	public void setPatname(String patname) {
		this.patname = patname;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	@Override
	public String toString() {
		return String.format("%d, %s, %s, %d", docid, appDate, patname, fees);
	}

	

}
