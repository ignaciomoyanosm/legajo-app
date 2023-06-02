package com.example.legajo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class FamiliaService {

    HashMap<String, Object> datos;

    private final FamiliaRepository familiaRepository;

    @Autowired
    public FamiliaService(FamiliaRepository familiaRepository){
        this.familiaRepository = familiaRepository;
    }

    public List<Familia> getFamilia() {
        return this.familiaRepository.findAll();
    }

    public ResponseEntity<Object> newFamilia(Familia familia) {
        datos = new HashMap <>();

        datos.put("message", "Se guardo con exito");
        if(familia.getId() !=null){
            datos.put("message","Se actualizo con exito");
        }
        familiaRepository.save(familia);
        datos.put("data", familia);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
    public ResponseEntity<Object> deleteFamilia(Long id){
        datos = new HashMap <>();
        boolean existe = this.familiaRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe un producto con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        familiaRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }

}
