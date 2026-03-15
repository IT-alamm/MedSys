package com.MedSys.service;

import com.MedSys.dto.PrescriptionDto;
import com.MedSys.entities.Prescription;

import java.util.List;

public interface PrescriptionService {

    PrescriptionDto createPrescription(PrescriptionDto prescriptionDto);

    List<PrescriptionDto> getAllPrescriptions();

    PrescriptionDto getPrescriptionById(Long id);

    List<PrescriptionDto> getByPatientId(Long patientId);

    List<PrescriptionDto> getByDoctorId(Long doctorId);

    void deletePrescription(Long id);
}
