package com.MedSys.controller;

import com.MedSys.entities.MedicalRecord;
import com.MedSys.service.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/medical-records")
public class MedicalRecordController {

    private final MedicalRecordService recordService;

    public MedicalRecordController(MedicalRecordService recordService) {
        this.recordService = recordService;
    }

    // ADD MEDICAL RECORD
    @PostMapping("/add")
    public ResponseEntity<Map<String,Object>> addRecord(
            @RequestParam Long patientId,
            @RequestParam Long doctorId,
            @RequestParam String diagnosis,
            @RequestParam String treatment) {

        MedicalRecord record = recordService.addRecord(
                patientId, doctorId, diagnosis, treatment);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Medical record added successfully");
        response.put("status", HttpStatus.CREATED.value());
        response.put("data", record);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET PATIENT RECORDS
    @GetMapping("/patient/{id}")
    public ResponseEntity<Map<String,Object>> getPatientRecords(@PathVariable Long id){

        List<MedicalRecord> list = recordService.getPatientRecords(id);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Patient medical records fetched");
        response.put("status", HttpStatus.OK.value());
        response.put("data", list);

        return ResponseEntity.ok(response);
    }

    // GET DOCTOR RECORDS
    @GetMapping("/doctor/{id}")
    public ResponseEntity<Map<String,Object>> getDoctorRecords(@PathVariable Long id){

        List<MedicalRecord> list = recordService.getDoctorRecords(id);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor medical records fetched");
        response.put("status", HttpStatus.OK.value());
        response.put("data", list);

        return ResponseEntity.ok(response);
    }
}
