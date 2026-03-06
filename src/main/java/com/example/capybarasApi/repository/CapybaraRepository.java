package com.example.capybarasApi.repository;

import com.example.capybarasApi.Capybara;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CapybaraRepository extends JpaRepository<Capybara, Long> {
}
