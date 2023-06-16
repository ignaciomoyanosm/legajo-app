package com.example.legajo.services;


import com.example.legajo.entities.Localidad;
import com.example.legajo.entities.Provincia;
import com.example.legajo.repositories.LocalidadRepository;
import com.example.legajo.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class LocalidadService {


    HashMap<String, Object> datos;

    private final LocalidadRepository localidadRepository;

    @Autowired
    public LocalidadService(LocalidadRepository localidadRepository){
        this.localidadRepository = localidadRepository;
    }

    public List<Localidad> getLocalidad() {
        return this.localidadRepository.findAll();
    }

    public ResponseEntity<Object> newLocalidad(Localidad localidad) {
        datos = new HashMap <>();

        datos.put("message", "Se guardo con exito");
        if(localidad.getId() !=null){
            datos.put("message","Se actualizo con exito");
        }
        localidadRepository.save(localidad);
        datos.put("data", localidad);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
    public ResponseEntity<Object> deleteLocalidad(Long id){
        datos = new HashMap <>();
        boolean existe = this.localidadRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe una provincia con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        localidadRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
