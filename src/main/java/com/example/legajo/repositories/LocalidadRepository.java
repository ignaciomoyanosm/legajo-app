package com.example.legajo.repositories;

import com.example.legajo.entities.Localidad;
import com.example.legajo.entities.Provincia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
}
