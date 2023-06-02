package com.example.legajo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
