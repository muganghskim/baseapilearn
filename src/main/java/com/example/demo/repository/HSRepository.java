package com.example.demo.repository;

import com.example.demo.data.HSData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HSRepository extends JpaRepository<HSData, Long> {
    Optional<HSData> findById(Long id);
}
