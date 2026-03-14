package com.MedSys.dto;

public class PatientDto {

    private Long id;
    private String name;
    private String email;
    private Long phone;
    private Long age;
    private String gender;

    public PatientDto(Long age, String email, String gender, Long id, String name, Long phone) {
        this.age = age;
        this.email = email;
        this.gender = gender;
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public PatientDto() {
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

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

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }
}
