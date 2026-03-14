package com.MedSys.repository;

import com.MedSys.dto.DoctorDto;
import com.MedSys.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findBySpecialization(String specialization);

}
