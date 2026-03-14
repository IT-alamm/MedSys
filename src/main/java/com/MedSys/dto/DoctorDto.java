package com.MedSys.dto;


public class DoctorDto {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String specialization;
    private int experience;
    private String availabilityStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(String availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public DoctorDto(Long id, String name, String email, String phone, String specialization, int experience, String availabilityStatus) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.specialization = specialization;
        this.experience = experience;
        this.availabilityStatus = availabilityStatus;
    }
}
