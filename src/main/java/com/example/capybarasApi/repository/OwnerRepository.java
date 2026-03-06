package com.example.capybarasApi.repository;

import com.example.capybarasApi.Capybara;
import com.example.capybarasApi.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
