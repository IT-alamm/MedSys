package com.MedSys.controller;

import com.MedSys.dto.DoctorDto;
import com.MedSys.entities.Doctor;
import com.MedSys.service.DoctorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/doctor")
public class DoctorController {

    private final DoctorService docServ;

    public DoctorController(DoctorService docServ) {
        this.docServ = docServ;
    }

    // SAVE Doctor
    @PostMapping("/save")
    public ResponseEntity<Map<String,Object>> saveDoctor(@RequestBody DoctorDto doctorDto){

        DoctorDto savedDoctor = docServ.saveDoctor(doctorDto);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor saved successfully");
        response.put("status", HttpStatus.CREATED.value());
        response.put("data", savedDoctor);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET ALL Doctors
    @GetMapping("/getAll")
    public ResponseEntity<Map<String,Object>> getDoctors(){

        List<Doctor> doctors = docServ.getAllDoctors();

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctors fetched successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", doctors);

        return ResponseEntity.ok(response);
    }

    // GET Doctor By ID
    @GetMapping("/getById/{id}")
    public ResponseEntity<Map<String,Object>> getDoctorById(@PathVariable Long id){

        Doctor doctor = docServ.getDoctorById(id);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor fetched successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", doctor);

        return ResponseEntity.ok(response);
    }

    // UPDATE Doctor
    @PutMapping("/update/{id}")
    public ResponseEntity<Map<String,Object>> updateDoctor(@PathVariable Long id,
                                                           @RequestBody Doctor doctor){

        Doctor updatedDoctor = docServ.updateDoctor(id, doctor);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor updated successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", updatedDoctor);

        return ResponseEntity.ok(response);
    }

    // DELETE Doctor
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String,Object>> deleteDoctor(@PathVariable Long id){

        docServ.deleteDoctor(id);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor deleted successfully");
        response.put("status", HttpStatus.OK.value());

        return ResponseEntity.ok(response);
    }

    // FIND Doctor By Specialization
    @GetMapping("/specialization/{spec}")
    public ResponseEntity<Map<String,Object>> getDoctorsBySpecialization(@PathVariable String spec){

        List<Doctor> doctors = docServ.getDoctorsBySpecialization(spec);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctors fetched by specialization");
        response.put("status", HttpStatus.OK.value());
        response.put("data", doctors);

        return ResponseEntity.ok(response);
    }

    // UPDATE Availability
    @PatchMapping("/{id}/availability")
    public ResponseEntity<Map<String,Object>> updateAvailability(@PathVariable Long id,
                                                                 @RequestParam String status){

        Doctor doctor = docServ.updateAvailability(id, status);

        Map<String,Object> response = new HashMap<>();
        response.put("message","Doctor availability updated");
        response.put("status", HttpStatus.OK.value());
        response.put("data", doctor);

        return ResponseEntity.ok(response);
    }
}
