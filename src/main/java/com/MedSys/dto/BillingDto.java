package com.MedSys.dto;

import java.time.LocalDate;


public class BillingDto {

    private Long id;
    private Long patientId;
    private Long appointmentId;
    private Double amount;
    private String paymentStatus;
    private LocalDate billDate;

    public BillingDto() {
    }

    public BillingDto(Double amount, Long appointmentId, LocalDate billDate, Long id, Long patientId, String paymentStatus) {
        this.amount = amount;
        this.appointmentId = appointmentId;
        this.billDate = billDate;
        this.id = id;
        this.patientId = patientId;
        this.paymentStatus = paymentStatus;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public LocalDate getBillDate() {
        return billDate;
    }

    public void setBillDate(LocalDate billDate) {
        this.billDate = billDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPatientId() {
        return patientId;
    }

    public void setPatientId(Long patientId) {
        this.patientId = patientId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
