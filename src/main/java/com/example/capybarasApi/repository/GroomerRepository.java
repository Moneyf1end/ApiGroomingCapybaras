package com.example.capybarasApi.repository;

import com.example.capybarasApi.Capybara;
import com.example.capybarasApi.Groomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroomerRepository extends JpaRepository<Groomer, Long> {
}
