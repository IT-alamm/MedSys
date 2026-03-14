package com.MedSys.service.serviceImpl;

import com.MedSys.dto.AdminDto;
import com.MedSys.entities.Admin;
import com.MedSys.exception.ResourceNotFoundException;
import com.MedSys.repo.AdminRepo;
import com.MedSys.service.AdminService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final ModelMapper modelMapper;
    private final AdminRepo adminRepo;

    public AdminServiceImpl(ModelMapper modelMapper, AdminRepo adminRepo) {
        this.modelMapper = modelMapper;
        this.adminRepo = adminRepo;
    }

    @Override
    public AdminDto createAdmin(AdminDto adminDTO) {

        Admin admin = modelMapper.map(adminDTO, Admin.class);

        Admin savedAdmin = adminRepo.save(admin);

        return modelMapper.map(savedAdmin, AdminDto.class);

    }

    @Override
    public List<AdminDto> getAllAdmins() {

        List<Admin> admins = adminRepo.findAll();
        return admins.stream()
                .map(admin -> modelMapper.map(admin, AdminDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public AdminDto getAdminById(Long id) {

        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : " + id));

        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public AdminDto updateAdmin(Long id, AdminDto adminDto) {

        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : " + id));

        admin.setName(adminDto.getName());
        admin.setEmail(adminDto.getEmail());

        Admin updatedAdmin = adminRepo.save(admin);

        return modelMapper.map(updatedAdmin, AdminDto.class);

    }

    @Override
    public void deleteAdmin(Long id) {

        Admin admin = adminRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Admin not found with id : " + id));

        adminRepo.delete(admin);

    }

}
