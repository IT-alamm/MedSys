package com.MedSys.service;

import com.MedSys.dto.PrescriptionDto;
import com.MedSys.entities.Prescription;
import com.MedSys.repo.PrescriptionRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

    private final PrescriptionRepo prescriptionRepo;
    private final ModelMapper modelMapper;

    public PrescriptionServiceImpl(PrescriptionRepo prescriptionRepo, ModelMapper modelMapper) {
        this.prescriptionRepo = prescriptionRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public PrescriptionDto createPrescription(PrescriptionDto dto) {

        Prescription prescription =
                modelMapper.map(dto, Prescription.class);

        Prescription saved = prescriptionRepo.save(prescription);

        return modelMapper.map(saved, PrescriptionDto.class);
    }

    @Override
    public List<PrescriptionDto> getAllPrescriptions() {

        return prescriptionRepo.findAll()
                .stream()
                .map(p -> modelMapper.map(p, PrescriptionDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public PrescriptionDto getPrescriptionById(Long id) {

        Prescription prescription = prescriptionRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Prescription not found"));

        return modelMapper.map(prescription, PrescriptionDto.class);
    }

    @Override
    public List<PrescriptionDto> getByPatientId(Long patientId) {

        List<Prescription> prescriptions = prescriptionRepo.findByPatientId(patientId);

        return prescriptions.stream()
                .map(p -> modelMapper.map(p, PrescriptionDto.class))
                .toList();
    }

    @Override
    public List<PrescriptionDto> getByDoctorId(Long doctorId) {

        List<Prescription> prescriptions = prescriptionRepo.findByDoctorId(doctorId);

        return prescriptions.stream()
                .map(p -> modelMapper.map(p, PrescriptionDto.class))
                .toList();
    }

    @Override
    public void deletePrescription(Long id) {
        prescriptionRepo.deleteById(id);
    }
}