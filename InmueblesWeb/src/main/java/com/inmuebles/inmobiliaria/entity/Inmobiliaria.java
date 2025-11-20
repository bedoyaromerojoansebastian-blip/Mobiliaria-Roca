package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Inmobiliaria")
public class Inmobiliaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Inmobiliaria")
    private Integer idInmobiliaria;

    @Column(name = "Nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "Direccion", nullable = false, length = 100)
    private String direccion;

    @Column(name = "Telefono", nullable = false, length = 20)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    // getters / setters
    public Integer getIdInmobiliaria() { return idInmobiliaria; }
    public void setIdInmobiliaria(Integer idInmobiliaria) { this.idInmobiliaria = idInmobiliaria; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}
