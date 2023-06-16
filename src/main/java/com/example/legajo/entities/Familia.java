package com.example.legajo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Familia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String parentesco;
    private String nombre_apellido;
    private String a_cargo;
    private String nivel_escolaridad;
    private String tipo_institucion;
    private String discapacidad;
    private String descripcion_discapacidad;
    private int edad;


    public Familia() {
    }

    public Familia(Long id, String parentesco, String nombre_apellido, String a_cargo, String nivel_escolaridad, String tipo_institucion, String discapacidad, String descripcion_discapacidad, int edad) {
        this.id = id;
        this.parentesco = parentesco;
        this.nombre_apellido = nombre_apellido;
        this.a_cargo = a_cargo;
        this.nivel_escolaridad = nivel_escolaridad;
        this.tipo_institucion = tipo_institucion;
        this.discapacidad = discapacidad;
        this.descripcion_discapacidad = descripcion_discapacidad;
        this.edad = edad;
    }

    public Familia(String parentesco, String nombre_apellido, String a_cargo, String nivel_escolaridad, String tipo_institucion, String discapacidad, String descripcion_discapacidad, int edad) {
        this.parentesco = parentesco;
        this.nombre_apellido = nombre_apellido;
        this.a_cargo = a_cargo;
        this.nivel_escolaridad = nivel_escolaridad;
        this.tipo_institucion = tipo_institucion;
        this.discapacidad = discapacidad;
        this.descripcion_discapacidad = descripcion_discapacidad;
        this.edad = edad;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getA_cargo() {
        return a_cargo;
    }

    public void setA_cargo(String a_cargo) {
        this.a_cargo = a_cargo;
    }

    public String getNivel_escolaridad() {
        return nivel_escolaridad;
    }

    public void setNivel_escolaridad(String nivel_escolaridad) {
        this.nivel_escolaridad = nivel_escolaridad;
    }

    public String getTipo_institucion() {
        return tipo_institucion;
    }

    public void setTipo_institucion(String tipo_institucion) {
        this.tipo_institucion = tipo_institucion;
    }

    public String getDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(String discapacidad) {
        this.discapacidad = discapacidad;
    }

    public String getDescripcion_discapacidad() {
        return descripcion_discapacidad;
    }

    public void setDescripcion_discapacidad(String descripcion_discapacidad) {
        this.descripcion_discapacidad = descripcion_discapacidad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
}
