package com.example.capybarasApi;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "owners")
@NoArgsConstructor
@Data
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("fullname")
    @Column(nullable = false, name = "fullname")
    private String fullName;

    @JsonProperty("phone")
    @Column(nullable = false, name = "phone")
    private String phone;

    @JsonProperty("email")
    @Column(nullable = false, name = "email")
    private String email;

    @JsonIgnore
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Capybara> capybaras;
}
