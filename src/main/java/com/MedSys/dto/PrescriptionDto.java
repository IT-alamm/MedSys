package com.MedSys.dto;

import java.time.LocalDate;

public class PrescriptionDto {

        private Long id;
        private Long patientId;
        private Long doctorId;
        private String medicineDetails;
        private String diagnosis;
        private LocalDate date;

        public PrescriptionDto() {}

        public PrescriptionDto(Long id, Long patientId, Long doctorId,
                               String medicineDetails, String diagnosis, LocalDate date) {
            this.id = id;
            this.patientId = patientId;
            this.doctorId = doctorId;
            this.medicineDetails = medicineDetails;
            this.diagnosis = diagnosis;
            this.date = date;
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

