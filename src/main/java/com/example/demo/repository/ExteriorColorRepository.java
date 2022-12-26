package com.example.demo.repository;

import com.example.demo.model.ExteriorColor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExteriorColorRepository extends JpaRepository<ExteriorColor, Long> {
}
