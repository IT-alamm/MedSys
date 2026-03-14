package com.MedSys.service;

import com.MedSys.entities.MedicalRecord;

import java.util.List;

public interface MedicalRecordService {
    MedicalRecord addRecord(Long patientId,
                            Long doctorId,
                            String diagnosis,
                            String treatment);

    List<MedicalRecord> getPatientRecords(Long patientId);

    List<MedicalRecord> getDoctorRecords(Long doctorId);
}
