package com.example.legajo.controllers;


import com.example.legajo.services.ProvinciaService;
import com.example.legajo.entities.Provincia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/provincia")
public class ProvinciaController {


    private final ProvinciaService provinciaService;

    @Autowired
    public ProvinciaController(ProvinciaService provinciaService){
        this.provinciaService = provinciaService;
    }

    @GetMapping
    public List<Provincia> getProvincia(){
        return this.provinciaService.getProvincia();
    }

    @PostMapping
    public ResponseEntity<Object> registrarProvincia(@RequestBody Provincia provincia){
        return this.provinciaService.newProvincia(provincia);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarProvincia(@RequestBody Provincia provincia){
        return this.provinciaService.newProvincia(provincia);
    }
    @DeleteMapping(path = "{provinciaId}")
    public ResponseEntity<Object> eliminar(@PathVariable("provinciaId") Long id){
        return this.provinciaService.deleteProvincia(id);
    }
}
