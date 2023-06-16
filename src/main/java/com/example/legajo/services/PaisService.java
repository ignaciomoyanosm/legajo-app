package com.example.legajo.services;


import com.example.legajo.entities.Pais;
import com.example.legajo.repositories.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class PaisService {

    HashMap<String, Object> datos;

    private final PaisRepository paisRepository;

    @Autowired
    public PaisService(PaisRepository paisRepository){
        this.paisRepository = paisRepository;
    }

    public List<Pais> getPais() {
        return this.paisRepository.findAll();
    }

    public ResponseEntity<Object> newPais(Pais pais) {
        datos = new HashMap <>();

        datos.put("message", "Se guardo con exito");
        if(pais.getId() !=null){
            datos.put("message","Se actualizo con exito");
        }
        paisRepository.save(pais);
        datos.put("data", pais);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
    public ResponseEntity<Object> deletePais(Long id){
        datos = new HashMap <>();
        boolean existe = this.paisRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe un pais con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        paisRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
