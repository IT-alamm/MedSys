package com.MedSys.service;

import com.MedSys.dto.PatientDto;
import com.MedSys.entities.Patient;

import java.util.List;

public interface PatientService{

     PatientDto RegisterPatient(PatientDto patientDto);

     PatientDto updatePatient (Long id,PatientDto patientDto);

     PatientDto getPatientById(Long id);

     List<PatientDto> getAllPatient();

     void deletePatient(Long id);


}
