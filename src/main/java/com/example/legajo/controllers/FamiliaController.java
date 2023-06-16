package com.example.legajo.controllers;

import com.example.legajo.entities.Familia;
import com.example.legajo.services.FamiliaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/familia")
public class FamiliaController {
    private final FamiliaService familiaService;


    @Autowired
    public FamiliaController(FamiliaService familiaService){
        this.familiaService = familiaService;
    }

    @GetMapping
    public List<Familia> getFamilia(){
        return this.familiaService.getFamilia();
    }

    @GetMapping(path = "/cargo")
    public List<String> getFamiliarCargo() { return this.familiaService.getFamiliarCargo();}

    @GetMapping(path = "/nombre_apellido")
    public List<String> getNombreApellido() { return this.familiaService.getNombreApellido();}
    @PostMapping
    public ResponseEntity<Object> registrarFamilia(@RequestBody Familia familia){
        return this.familiaService.newFamilia(familia);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarFamilia(@RequestBody Familia familia){
        return this.familiaService.newFamilia(familia);
    }
    @DeleteMapping(path = "{familiaId}")
    public ResponseEntity<Object> eliminar(@PathVariable("familiaId") Long id){
        return this.familiaService.deleteFamilia(id);
    }
}
