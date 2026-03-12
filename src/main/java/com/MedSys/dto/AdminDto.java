package com.MedSys.dto;

public class AdminDto {

        private Long id;
        private String name;
        private String email;


    public AdminDto(String email, Long id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public AdminDto() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
}

