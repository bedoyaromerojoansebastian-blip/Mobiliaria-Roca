package com.inmuebles.inmobiliaria.entity;


import jakarta.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table(name = "Compra")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Compra")
    private Integer id;

    @Column(name = "Fecha", nullable = false)
    private LocalDate fecha;

    @Column(name = "Monto", nullable = false)
    private BigDecimal monto;

    @ManyToOne
    @JoinColumn(name = "ID_Cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "ID_Propiedad", nullable = false)
    private Propiedad propiedad;

    public Compra() {}

    public Compra(Integer id, LocalDate fecha, BigDecimal monto, Cliente cliente, Propiedad propiedad) {
        this.id = id;
        this.fecha = fecha;
        this.monto = monto;
        this.cliente = cliente;
        this.propiedad = propiedad;
    }

    // GETTERS & SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public BigDecimal getMonto() { return monto; }
    public void setMonto(BigDecimal monto) { this.monto = monto; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Propiedad getPropiedad() { return propiedad; }
    public void setPropiedad(Propiedad propiedad) { this.propiedad = propiedad; }
}
