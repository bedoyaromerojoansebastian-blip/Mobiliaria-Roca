package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Propiedad")
public class Propiedad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Propiedad")
    private Integer id;

    @Column(name = "Tipo", nullable = false, length = 45)
    private String tipo;

    @Column(name = "Ubicacion", nullable = false, length = 100)
    private String ubicacion;

    @Column(name = "Precio", nullable = false)
    private Double precio;

    @Column(name = "Habitaciones", nullable = false)
    private Integer habitaciones;

    @ManyToOne
    @JoinColumn(name = "ID_Propietario", nullable = false)
    private Propietario propietario;

    @ManyToOne
    @JoinColumn(name = "ID_Inmobiliaria", nullable = false)
    private Inmobiliaria inmobiliaria;

    public Propiedad() {}

    public Propiedad(Integer id, String tipo, String ubicacion, Double precio, Integer habitaciones, Propietario propietario, Inmobiliaria inmobiliaria) {
        this.id = id;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.habitaciones = habitaciones;
        this.propietario = propietario;
        this.inmobiliaria = inmobiliaria;
    }

    // Getters y Setters

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }

    public Integer getHabitaciones() { return habitaciones; }
    public void setHabitaciones(Integer habitaciones) { this.habitaciones = habitaciones; }

    public Propietario getPropietario() { return propietario; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }

    public Inmobiliaria getInmobiliaria() { return inmobiliaria; }
    public void setInmobiliaria(Inmobiliaria inmobiliaria) { this.inmobiliaria = inmobiliaria; }
}

