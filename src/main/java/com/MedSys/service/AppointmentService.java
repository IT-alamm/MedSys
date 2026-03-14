package com.MedSys.service;

import com.MedSys.entities.Appointment;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentService {

    Appointment bookAppointment(Long patientId,
                                Long doctorId,
                                LocalDate date,
                                LocalTime time);

    List<Appointment> getDoctorAppointments(Long doctorId);

    List<Appointment> getPatientAppointments(Long patientId);

    Appointment cancelAppointment(Long appointmentId);

    List<Appointment> findDoctorById(Long doctorId);

    List<Appointment> findByPatientId(Long patientId);
}
