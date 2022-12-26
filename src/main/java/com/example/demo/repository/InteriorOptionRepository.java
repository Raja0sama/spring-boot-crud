package com.example.demo.repository;

import com.example.demo.model.InteriorOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteriorOptionRepository extends JpaRepository<InteriorOption, Long> {
}
