package com.example.legajo.services;

import com.example.legajo.entities.Domicilio;
import com.example.legajo.entities.Localidad;
import com.example.legajo.repositories.DomicilioRepository;
import com.example.legajo.repositories.LocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service
public class DomicilioService {


    HashMap<String, Object> datos;

    private final DomicilioRepository domicilioRepository;

    @Autowired
    public DomicilioService(DomicilioRepository domicilioRepository){
        this.domicilioRepository = domicilioRepository;
    }

    public List<Domicilio> getDomicilio() {
        return this.domicilioRepository.findAll();
    }

    public ResponseEntity<Object> newDomicilio(Domicilio domicilio) {
        datos = new HashMap <>();

        datos.put("message", "Se guardo con exito");
        if(domicilio.getId() !=null){
            datos.put("message","Se actualizo con exito");
        }
        domicilioRepository.save(domicilio);
        datos.put("data", domicilio);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
    public ResponseEntity<Object> deleteDomicilio(Long id){
        datos = new HashMap <>();
        boolean existe = this.domicilioRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe una provincia con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        domicilioRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}

