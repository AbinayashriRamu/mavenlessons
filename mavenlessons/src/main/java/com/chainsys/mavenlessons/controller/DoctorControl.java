package com.chainsys.mavenlessons.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import com.chainsys.mavenlessons.entity.Appointment;
import com.chainsys.mavenlessons.entity.Doctor;
import com.chainsys.mavenlessons.repository.DoctorRepository;

@RestController
public class DoctorControl {
	@Autowired
	private DoctorRepository repo;

//	@Bean
//	public void setRepo(DoctorRepository repo) {
//		this.repo = repo;
//	}

//	@GetMapping("/getdoctor")
//	public Doctor getDoctor(int id) {
//		return repo.findById(id);
//	}
	@GetMapping(value="/getdoctorappointment")
	public String getDoctor(int id) {
		return repo.findById(id).toString();
	}
	@GetMapping(value="getdoctorappointments")
	public String getAppointments(int id) {
		Doctor doc=repo.findById(id);
		List<Appointment>appointments=doc.getAppointments();
		return appointments.toString();
	}
	@GetMapping(value="/getalldoctors")
	public List<Doctor> getDoctors() {
		return repo.findAll();
	}
	

	@DeleteMapping(value="/deletedoctor")
	public RedirectView deleteDoctor(int id) {
		repo.deleteById(id);
		return new RedirectView("/getalldoctors");
	}

	@PostMapping(value = "/newdoctor", consumes = "application/json")
	// we need give from where to read data from the HTTP request and also the
	// content type ("application/json")
	public RedirectView addDoctor(@RequestBody Doctor dr) {
		repo.save(dr);
		return new RedirectView("/getalldoctors");

	}

	@PostMapping(value = "/modifydoctor", consumes = "application/json")
	public RedirectView modifyDoctor(@RequestBody Doctor dr) {
		repo.save(dr);
		return new RedirectView("/getalldoctors");

	}

	
}