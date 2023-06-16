package com.example.legajo.controllers;


import com.example.legajo.services.PaisService;
import com.example.legajo.entities.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "api/v1/pais")
public class PaisController {

    private final PaisService paisService;

    @Autowired
    public PaisController(PaisService paisService){
        this.paisService = paisService;
    }

    @GetMapping
    public List<Pais> getPais(){
        return this.paisService.getPais();
    }

    @PostMapping
    public ResponseEntity<Object> registrarPais(@RequestBody Pais pais){
        return this.paisService.newPais(pais);
    }
    @PutMapping
    public ResponseEntity<Object> actualizarPais(@RequestBody Pais pais){
        return this.paisService.newPais(pais);
    }
    @DeleteMapping(path = "{paisId}")
    public ResponseEntity<Object> eliminar(@PathVariable("paisId") Long id){
        return this.paisService.deletePais(id);
    }
}
