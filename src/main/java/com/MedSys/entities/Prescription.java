package com.MedSys.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "prescriptions")
public class Prescription {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long patientId;

    private Long doctorId;

    private String medicineDetails;

    private String diagnosis;

    private LocalDate date;

    public Prescription() {
    }

    public Prescription(LocalDate date, String diagnosis, Long doctorId, Long id, String medicineDetails, Long patientId) {
        this.date = date;
        this.diagnosis = diagnosis;
        this.doctorId = doctorId;
        this.id = id;
        this.medicineDetails = medicineDetails;
        this.patientId = patientId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMedicineDetails() {
        return medicineDetails;
    }

    public void setMedicineDetails(String medicineDetails) {
        this.medicineDetails = medicineDetails;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }
}
