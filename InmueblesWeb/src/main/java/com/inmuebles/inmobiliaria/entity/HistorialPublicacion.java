package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Historial_Publicacion")
public class HistorialPublicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Historial")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_Publicacion", nullable = false)
    private Publicacion publicacion;

    @Column(name = "Fecha_Interaccion", nullable = false)
    private LocalDate fechaInteraccion;

    public HistorialPublicacion() {}

    public HistorialPublicacion(Integer id, Cliente cliente, Publicacion publicacion, LocalDate fechaInteraccion) {
        this.id = id;
        this.cliente = cliente;
        this.publicacion = publicacion;
        this.fechaInteraccion = fechaInteraccion;
    }

    // GETTERS & SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Publicacion getPublicacion() { return publicacion; }
    public void setPublicacion(Publicacion publicacion) { this.publicacion = publicacion; }

    public LocalDate getFechaInteraccion() { return fechaInteraccion; }
    public void setFechaInteraccion(LocalDate fechaInteraccion) { this.fechaInteraccion = fechaInteraccion; }
}
