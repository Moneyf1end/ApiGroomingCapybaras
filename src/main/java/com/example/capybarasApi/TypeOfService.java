package com.example.capybarasApi;

import com.example.capybarasApi.enums.DifficultyLevel;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "service_type")
@NoArgsConstructor
@Data
public class TypeOfService {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("servicename")
    @Column(nullable = false, name = "service_name")
    private String serviceName;

    @JsonProperty("description")
    @Column(nullable = false, name = "desc")
    private String description;

    @JsonProperty("duration")
    @Column(nullable = false, name = "duration")
    private int durationMinutes;

    @JsonProperty("price")
    @Column(nullable = false, name = "price")
    private float price;

    @Enumerated(EnumType.STRING)
    private DifficultyLevel difficultyLevel;

    @ManyToMany(mappedBy = "services")
    private List<Appointment> appointments;
}
