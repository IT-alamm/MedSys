package com.MedSys.service;

import com.MedSys.dto.DoctorDto;
import com.MedSys.entities.Doctor;
import com.MedSys.repository.DoctorRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository docRepo;
    private final ModelMapper modelMapper;

    public DoctorServiceImpl(DoctorRepository docRepo, ModelMapper modelMapper) {
        this.docRepo = docRepo;
        this.modelMapper = modelMapper;
    }

    // CREATE (DTO → ENTITY → SAVE → DTO)
    @Override
    public DoctorDto saveDoctor(DoctorDto doctorDto) {

        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);

        Doctor savedDoctor = docRepo.save(doctor);

        return modelMapper.map(savedDoctor, DoctorDto.class);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return docRepo.findAll();
    }

    // READ BY ID
    @Override
    public Doctor getDoctorById(Long id) {
        return docRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found with id: " + id));
    }

    // UPDATE
    @Override
    public Doctor updateDoctor(Long id, Doctor doctor) {

        Doctor existingDoctor = docRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        existingDoctor.setName(doctor.getName());
        existingDoctor.setEmail(doctor.getEmail());
        existingDoctor.setPhone(doctor.getPhone());
        existingDoctor.setSpecialization(doctor.getSpecialization());
        existingDoctor.setExperience(doctor.getExperience());
        existingDoctor.setAvailabilityStatus(doctor.getAvailabilityStatus());

        return docRepo.save(existingDoctor);
    }

    // DELETE
    @Override
    public void deleteDoctor(Long id) {
        docRepo.deleteById(id);
    }

    // BUSINESS METHOD
    @Override
    public Doctor updateAvailability(Long id, String status) {

        Doctor doctor = docRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        doctor.setAvailabilityStatus(status);

        return docRepo.save(doctor);
    }

    // FIND BY SPECIALIZATION
    @Override
    public List<Doctor> getDoctorsBySpecialization(String specialization) {
        return docRepo.findBySpecialization(specialization);
    }


//    public Doctor dtoToDoctor(DoctorDto doctorDto){
//        Doctor doctor=this.modelMapper.map(doctorDto,Doctor.class);
//        return doctor;
//    }
//
//    public DoctorDto doctorToDto(Doctor doctor){
//        DoctorDto doctorDto=this.modelMapper.map(doctor,DoctorDto.class);
//        return doctorDto;
//    }

}
