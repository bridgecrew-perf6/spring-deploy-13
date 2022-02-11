package com.example.Sesiones456.repositories;

import com.example.Sesiones456.entities.LapTop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaptopRepository extends JpaRepository<LapTop, Long> {
}
