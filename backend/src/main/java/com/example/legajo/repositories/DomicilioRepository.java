package com.example.legajo.repositories;

import com.example.legajo.entities.Domicilio;
import com.example.legajo.entities.Familia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
