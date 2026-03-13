package com.example.capybarasApi;

import com.example.capybarasApi.enums.AppointmentStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.*;

@Entity
@Table(name = "appointment")
@NoArgsConstructor
@Data
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("start_time")
    @Column(nullable = false, name = "start_time")
    private LocalDateTime startTime;

    @JsonProperty("status")
    @Enumerated(EnumType.STRING)
    private AppointmentStatus status;

    @ManyToOne
    @JoinColumn(name = "capybara_id")
    private Capybara capybara;

    @ManyToOne
    @JoinColumn(name = "groomer_id")
    private Groomer groomer;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
            name = "appointment_services",
            joinColumns = @JoinColumn(name = "appointment_id"),
            inverseJoinColumns = @JoinColumn(name = "service_type_id")
    )
    private List<TypeOfService> services;
}
