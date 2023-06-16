package com.example.legajo.repositories;

import com.example.legajo.entities.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Long> {

    @Query("SELECT f.a_cargo FROM Familia f")
    List<String> findA_cargo();

    @Query("SELECT f.nombre_apellido FROM Familia f")
    List<String> findNombreApellido();


}
