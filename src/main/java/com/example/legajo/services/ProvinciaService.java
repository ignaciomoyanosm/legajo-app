package com.example.legajo.services;

import com.example.legajo.entities.Provincia;
import com.example.legajo.repositories.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProvinciaService {

    HashMap<String, Object> datos;

    private final ProvinciaRepository provinciaRepository;

    @Autowired
    public ProvinciaService(ProvinciaRepository provinciaRepository){
        this.provinciaRepository = provinciaRepository;
    }

    public List<Provincia> getProvincia() {
        return this.provinciaRepository.findAll();
    }

    public ResponseEntity<Object> newProvincia(Provincia provincia) {
        datos = new HashMap <>();

        datos.put("message", "Se guardo con exito");
        if(provincia.getId() !=null){
            datos.put("message","Se actualizo con exito");
        }
        provinciaRepository.save(provincia);
        datos.put("data", provincia);

        return new ResponseEntity<>(
                datos,
                HttpStatus.CREATED
        );

    }
    public ResponseEntity<Object> deleteProvincia(Long id){
        datos = new HashMap <>();
        boolean existe = this.provinciaRepository.existsById(id);
        if (!existe){
            datos.put("error", true);
            datos.put("message", "No existe una provincia con ese id");
            return new ResponseEntity<>(
                    datos,
                    HttpStatus.CONFLICT
            );
        }
        provinciaRepository.deleteById(id);
        datos.put("message", "Producto eliminado");
        return new ResponseEntity<>(
                datos,
                HttpStatus.ACCEPTED
        );
    }
}
