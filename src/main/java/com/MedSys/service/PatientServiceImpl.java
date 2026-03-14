package com.MedSys.service.serviceImpl;

import com.MedSys.dto.PatientDto;
import com.MedSys.entities.Patient;
import com.MedSys.repo.PatientRepo;
import com.MedSys.service.PatientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PatientServiceImpl implements PatientService {

    private final PatientRepo patientRepo;
    private final ModelMapper modelMapper;

    public PatientServiceImpl(PatientRepo patientRepo, ModelMapper modelMapper) {
        this.patientRepo = patientRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public PatientDto RegisterPatient(PatientDto patientDto) {

        //DTO to entity
        Patient patient = modelMapper.map(patientDto, Patient.class);

        //save to db
        Patient savedPatient = patientRepo.save(patient);


        //entity to dto
        return modelMapper.map(savedPatient, PatientDto.class);


    }

    @Override
    public PatientDto updatePatient(Long id, PatientDto patientDto) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setName(patient.getName());
        patient.setAge(patient.getAge());
        patient.setEmail(patient.getEmail());
        patient.setGender(patient.getGender());
        patient.setPhone(patient.getPhone());

        Patient updatedPatient = patientRepo.save(patient);
        return modelMapper.map(updatedPatient, PatientDto.class);

    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepo
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found with this id: " + id));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatient() {
        List<Patient> patients = patientRepo.findAll();

        return patients.stream()
                .map(patient -> modelMapper.map(patient, PatientDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public void deletePatient(Long id) {
        Patient patient = patientRepo.findById(id).orElseThrow(() -> new RuntimeException("Patient not found with this id: " + id));
        patientRepo.delete(patient);
    }
}
