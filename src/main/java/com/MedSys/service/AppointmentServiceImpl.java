package com.MedSys.service;

import com.MedSys.entities.Appointment;
import com.MedSys.entities.Doctor;
import com.MedSys.entities.Patient;
import com.MedSys.repo.AppointmentRepository;
import com.MedSys.repo.DoctorRepository;
import com.MedSys.repo.PatientRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appRepo;
    private final PatientRepo patientRepo;
    private final DoctorRepository doctorRepo;

    public AppointmentServiceImpl(AppointmentRepository appRepo,
                                  PatientRepo patientRepo,
                                  DoctorRepository doctorRepo) {
        this.appRepo = appRepo;
        this.patientRepo = patientRepo;
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Appointment bookAppointment(Long patientId,
                                       Long doctorId,
                                       LocalDate date,
                                       LocalTime time) {

        Patient patient = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        Doctor doctor = doctorRepo.findById(doctorId)
                .orElseThrow(() -> new RuntimeException("Doctor not found"));

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentDate(date);
        appointment.setAppointmentTime(time);
        appointment.setStatus("Scheduled");

        return appRepo.save(appointment);
    }

    @Override
    public List<Appointment> getDoctorAppointments(Long doctorId) {
        return appRepo.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> getPatientAppointments(Long patientId) {
        return appRepo.findByPatientId(patientId);
    }

    @Override
    public Appointment cancelAppointment(Long appointmentId) {

        Appointment appointment = appRepo.findById(appointmentId)
                .orElseThrow(() -> new RuntimeException("Appointment not found"));

        appointment.setStatus("Cancelled");

        return appRepo.save(appointment);
    }

    @Override
    public List<Appointment> findDoctorById(Long doctorId) {
        return appRepo.findByDoctorId(doctorId);
    }

    @Override
    public List<Appointment> findByPatientId(Long patientId) {
        return appRepo.findByPatientId(patientId);
    }
}
