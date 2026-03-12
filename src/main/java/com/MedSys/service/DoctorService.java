package com.MedSys.service;

import com.MedSys.dto.DoctorDto;
import com.MedSys.entities.Doctor;

import java.util.List;

public interface DoctorService {
     DoctorDto saveDoctor(DoctorDto doctorDto);

     List<Doctor> getAllDoctors();

    Doctor getDoctorById(Long id);

    List<Doctor> getDoctorsBySpecialization(String specialization);

    // UPDATE
    Doctor updateDoctor(Long id, Doctor doctor);

    // DELETE
    void deleteDoctor(Long id);

    // BUSINESS LOGIC
    Doctor updateAvailability(Long id, String status);


}
