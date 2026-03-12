package com.MedSys.controller;

import com.MedSys.entities.Appointment;
import com.MedSys.service.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointService;

    public AppointmentController(AppointmentService appointService) {
        this.appointService = appointService;
    }

    // BOOK APPOINTMENT
    @PostMapping("/book")
    public ResponseEntity<Map<String, Object>> book(@RequestParam Long patientId,
                                                    @RequestParam Long doctorId,
                                                    @RequestParam String date,
                                                    @RequestParam String time) {

        Appointment appointment = appointService.bookAppointment(
                patientId,
                doctorId,
                LocalDate.parse(date),
                LocalTime.parse(time)
        );

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Appointment booked successfully");
        response.put("status", HttpStatus.CREATED.value());
        response.put("data", appointment);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // GET DOCTOR APPOINTMENTS
    @GetMapping("/doctor/{id}")
    public ResponseEntity<Map<String, Object>> getDoctorAppointmentsById(@PathVariable Long id){

        List<Appointment> list = appointService.getDoctorAppointments(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Doctor appointments fetched successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", list);

        return ResponseEntity.ok(response);
    }

    // GET PATIENT APPOINTMENTS
    @GetMapping("/patient/{id}")
    public ResponseEntity<Map<String, Object>> getPatientAppointmentsById(@PathVariable Long id){

        List<Appointment> list = appointService.getPatientAppointments(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Patient appointments fetched successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", list);

        return ResponseEntity.ok(response);
    }

    // CANCEL APPOINTMENT
    @PatchMapping("/cancel/{id}")
    public ResponseEntity<Map<String, Object>> cancelById(@PathVariable Long id){

        Appointment appointment = appointService.cancelAppointment(id);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Appointment cancelled successfully");
        response.put("status", HttpStatus.OK.value());
        response.put("data", appointment);

        return ResponseEntity.ok(response);
    }
}
