package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Contrato")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Contrato")
    private Integer id;

    @Column(name = "Fecha_inicio", nullable = false)
    private LocalDate fechaInicio;

    @Column(name = "Fecha_fin", nullable = false)
    private LocalDate fechaFin;

    @Column(name = "Terminos", columnDefinition = "LONGTEXT", nullable = false)
    private String terminos;

    @OneToOne
    @JoinColumn(name = "ID_Compra", nullable = false)
    private Compra compra;

    public Contrato() {}

    public Contrato(Integer id, LocalDate fechaInicio, LocalDate fechaFin, String terminos, Compra compra) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.terminos = terminos;
        this.compra = compra;
    }

    // GETTERS & SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDate getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDate fechaFin) { this.fechaFin = fechaFin; }

    public String getTerminos() { return terminos; }
    public void setTerminos(String terminos) { this.terminos = terminos; }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }
}
