package com.example.capybarasApi.repository;

import com.example.capybarasApi.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}
