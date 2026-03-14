package com.MedSys.service;

import com.MedSys.entities.Doctor;
import com.MedSys.entities.MedicalRecord;
import com.MedSys.entities.Patient;
import com.MedSys.repo.PatientRepo;
import com.MedSys.repository.DoctorRepository;
import com.MedSys.repository.MedicalRecordRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository recordRepo;
    private final PatientRepo patientRepo;
    private final DoctorRepository doctorRepo;

    public MedicalRecordServiceImpl(MedicalRecordRepository recordRepo,
                                    PatientRepo patientRepo,
                                    DoctorRepository doctorRepo) {
        this.recordRepo = recordRepo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    // ADD MEDICAL RECORD
    @Override
    public MedicalRecord addRecord(Long patientId,
                                   Long doctorId,
                                   String diagnosis,
                                   String treatment) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() ->
                        new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() ->
                        new RuntimeException("Doctor not found"));

        MedicalRecord record = new MedicalRecord();
        record.setPatient(patient);
        record.setDoctor(doctor);
        record.setDiagnosis(diagnosis);
        record.setTreatment(treatment);
        record.setRecordDate(LocalDate.now());

        return recordRepo.save(record);
    }

    // GET PATIENT HISTORY
    @Override
    public List<MedicalRecord> getPatientRecords(Long patientId) {
        return recordRepo.findByPatientId(patientId);
    }

    // GET DOCTOR HISTORY
    @Override
    public List<MedicalRecord> getDoctorRecords(Long doctorId) {
        return recordRepo.findByDoctorId(doctorId);
    }
}

