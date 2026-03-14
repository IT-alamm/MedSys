package com.MedSys.controller;

import com.MedSys.dto.PrescriptionDto;
import com.MedSys.service.PrescriptionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    private final PrescriptionService prescriptionService;

    public PrescriptionController(PrescriptionService prescriptionService) {
        this.prescriptionService = prescriptionService;
    }


    @PostMapping("/create")
    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto prescriptionDto) {

        PrescriptionDto savedPrescription = prescriptionService.createPrescription(prescriptionDto);

        return new ResponseEntity<>(savedPrescription, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PrescriptionDto>> getAllPrescriptions() {

        List<PrescriptionDto> prescriptions = prescriptionService.getAllPrescriptions();

        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("getPrescriptionById/{id}")
    public ResponseEntity<PrescriptionDto> getPrescriptionById(@PathVariable Long id) {

        PrescriptionDto prescription = prescriptionService.getPrescriptionById(id);

        return ResponseEntity.ok(prescription);
    }

    @GetMapping("/getByPatient/{patientId}")
    public ResponseEntity<List<PrescriptionDto>> getByPatient(@PathVariable Long patientId) {

        List<PrescriptionDto> prescriptions = prescriptionService.getByPatientId(patientId);

        return ResponseEntity.ok(prescriptions);
    }

    @GetMapping("/getByDoctor/{doctorId}")
    public ResponseEntity<List<PrescriptionDto>> getByDoctor(@PathVariable Long doctorId) {

        List<PrescriptionDto> prescriptions = prescriptionService.getByDoctorId(doctorId);

        return ResponseEntity.ok(prescriptions);
    }

    @DeleteMapping("deletePrescription/{id}")
    public ResponseEntity<String> deletePrescription(@PathVariable Long id) {

        prescriptionService.deletePrescription(id);

        return ResponseEntity.status(HttpStatus.OK)
                .body("Prescription deleted successfully");
    }
}