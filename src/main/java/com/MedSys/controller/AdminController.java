package com.MedSys.controller;

import com.MedSys.dto.AdminDto;
import com.MedSys.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/create")
    public ResponseEntity<AdminDto> createAdmin(@RequestBody AdminDto adminDto) {
        AdminDto dto = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<AdminDto> getAllAdmins() {
        return adminService.getAllAdmins();
    }

    @GetMapping("/getAdminById/{id}")
    public ResponseEntity<AdminDto> getAdminById(@PathVariable Long id) {
        AdminDto dto = adminService.getAdminById(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping("/updateAdmin/{id}")
    public AdminDto updateAdmin(@PathVariable Long id,
                                @RequestBody AdminDto adminDto) {

        adminDto.setId(adminDto.getId());
        adminDto.setName(adminDto.getName());
        adminDto.setEmail(adminDto.getEmail());
        return adminService.updateAdmin(id, adminDto);
    }

    @DeleteMapping("/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        adminService.deleteAdmin(id);
        return "Admin deleted successfully";
    }
}

