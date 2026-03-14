package com.MedSys.controller;

import com.MedSys.dto.PatientDto;
import com.MedSys.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping("/register")
    public ResponseEntity<PatientDto> RegisterPatient(@RequestBody PatientDto patientDto) {
        PatientDto patientDto1 = patientService.RegisterPatient(patientDto);
        return new ResponseEntity<>(patientDto1, HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PatientDto> getPatientById(@PathVariable Long id) {
        PatientDto patientDto = patientService.getPatientById(id);
        return ResponseEntity.ok(patientDto);
    }

    @GetMapping()
    public ResponseEntity<List<PatientDto>> getAllPatient() {
        List<PatientDto> patientDto = patientService.getAllPatient();
        return ResponseEntity.ok(patientDto);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<PatientDto> updatePatient(@PathVariable Long id, @RequestBody PatientDto patientDto) {
        PatientDto updatedPatient = patientService.updatePatient(id, patientDto);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok("Patient deleted successfully");
    }

}
