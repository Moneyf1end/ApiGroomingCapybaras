package com.example.capybarasApi;

import com.example.capybarasApi.enums.CapybarasMood;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "capybara")
@NoArgsConstructor
@Data
public class Capybara {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("nickname")
    @Column(nullable = false, name = "nickname")
    private String nickName;

    @JsonProperty("weight")
    @Column(nullable = false, name = "weight_kg")
    private float weightKg;

    @JsonProperty("assType")
    @Column(nullable = false, name = "ass_type")
    private String assType;

    @JsonProperty("mood")
    @Column(nullable = false, name = "capybaras_mood")
    @Enumerated(EnumType.STRING)
    private CapybarasMood mood;

    @OneToMany(mappedBy = "capybara", cascade = CascadeType.ALL)
    private List<Appointment> appointments;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

}
