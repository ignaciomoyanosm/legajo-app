package com.example.legajo.controllers;


import com.example.legajo.entities.Localidad;
import com.example.legajo.entities.Provincia;
import com.example.legajo.services.LocalidadService;
import com.example.legajo.services.ProvinciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/localidad")
public class LocalidadController {




    private final LocalidadService localidadService;

    @Autowired
    public LocalidadController(LocalidadService localidadService){
        this.localidadService = localidadService;
    }

    @GetMapping
    public List<Localidad> getLocalidad(){
        return this.localidadService.getLocalidad();
    }

    @PostMapping
    public ResponseEntity<Object> registrarLocalidad(@RequestBody Localidad localidad){
        return this.localidadService.newLocalidad(localidad);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarLocalidad(@RequestBody Localidad localidad){
        return this.localidadService.newLocalidad(localidad);
    }
    @DeleteMapping(path = "{localidadId}")
    public ResponseEntity<Object> eliminar(@PathVariable("localidadId") Long id){
        return this.localidadService.deleteLocalidad(id);
    }


}
