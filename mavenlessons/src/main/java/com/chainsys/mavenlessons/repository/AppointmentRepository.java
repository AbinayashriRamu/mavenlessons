package com.chainsys.mavenlessons.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.chainsys.mavenlessons.entity.Appointment;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
    Appointment findById(int id);

    Appointment save(Appointment apt);
   

    // Used for both adding new Appointment and Modifying new Appointment
    void deleteById(int id);

    List<Appointment> findAll();
   // @Query("select a from Appointment a where a.docid=?1")
    // jpql - java persistence query language
    // here a is an instance of Appointment
    //List<Appointment> findAllByDoctorId(int docid);
    List<Appointment>findByDoctorId(int docId);
}