package com.example.capybarasApi;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "groomer")
@NoArgsConstructor
@Data
public class Groomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("fullname")
    @Column(nullable = false, name = "fullname")
    private String fullName;

    @JsonProperty("gender")
    @Column(nullable = false, name = "gender")
    private String gender;

    @JsonProperty("phone")
    @Column(nullable = false, name = "phone")
    private String phone;

    @JsonProperty("experience")
    @Column(nullable = false, name = "experienceYears")
    private int experience;

    @OneToMany(mappedBy = "groomer")
    private List<Appointment> appointments;
}
