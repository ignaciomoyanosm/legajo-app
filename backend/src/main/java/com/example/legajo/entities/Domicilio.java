package com.example.legajo.entities;


import jakarta.persistence.*;

@Entity
@Table
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "localidad_id")
    private Localidad localidad;

    private String calle;

    private int numero;

    private String departamento;

    private String codigo_postal;

    private String url_maps;

    public Domicilio() {
    }

    public Domicilio(Long id, Localidad localidad, String calle, int numero, String departamento, String codigo_postal, String url_maps) {
        this.id = id;
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.codigo_postal = codigo_postal;
        this.url_maps = url_maps;
    }

    public Domicilio(Localidad localidad, String calle, int numero, String departamento, String codigo_postal, String url_maps) {
        this.localidad = localidad;
        this.calle = calle;
        this.numero = numero;
        this.departamento = departamento;
        this.codigo_postal = codigo_postal;
        this.url_maps = url_maps;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getUrl_maps() {
        return url_maps;
    }

    public void setUrl_maps(String url_maps) {
        this.url_maps = url_maps;
    }
}
