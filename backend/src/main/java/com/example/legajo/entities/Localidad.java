package com.example.legajo.entities;


import jakarta.persistence.*;

@Entity
@Table
public class Localidad {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "provincia_id")
    private Provincia provincia;

    private String nombre;

    public Localidad() {
    }

    public Localidad(Long id, Provincia provincia, String nombre) {
        this.id = id;
        this.provincia = provincia;
        this.nombre = nombre;
    }

    public Localidad(Provincia provincia, String nombre) {
        this.provincia = provincia;
        this.nombre = nombre;
    }

    public Localidad(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
