package com.example.legajo.controllers;

import com.example.legajo.entities.Domicilio;
import com.example.legajo.entities.Localidad;
import com.example.legajo.services.DomicilioService;
import com.example.legajo.services.LocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/domicilio")
public class DomicilioController {






    private final DomicilioService domicilioService;

    @Autowired
    public DomicilioController(DomicilioService domicilioService){
        this.domicilioService = domicilioService;
    }

    @GetMapping
    public List<Domicilio> getDomicilio(){return this.domicilioService.getDomicilio();
    }

    @PostMapping
    public ResponseEntity<Object> registrarDomicilio(@RequestBody Domicilio domicilio){
        return this.domicilioService.newDomicilio(domicilio);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarDomicilio(@RequestBody Domicilio domicilio){
        return this.domicilioService.newDomicilio(domicilio);
    }
    @DeleteMapping(path = "{domicilioId}")
    public ResponseEntity<Object> eliminar(@PathVariable("domicilioId") Long id){
        return this.domicilioService.deleteDomicilio(id);
    }


}
