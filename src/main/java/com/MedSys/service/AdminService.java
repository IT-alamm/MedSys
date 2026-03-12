package com.MedSys.service;

import com.MedSys.dto.AdminDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AdminService {

    AdminDto createAdmin(AdminDto adminDto);

    AdminDto updateAdmin(Long id, AdminDto adminDto);

    List<AdminDto> getAllAdmins();

    AdminDto getAdminById(Long id);

    void deleteAdmin(Long id);
}

