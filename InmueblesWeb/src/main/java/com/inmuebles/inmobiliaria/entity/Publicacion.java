package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Publicacion")
public class Publicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Publicacion")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_Propiedad", nullable = false)
    private Propiedad propiedad;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false)
    private Usuario usuario;

    @Column(name = "Estado", nullable = false, length = 45)
    private String estado;

    @Column(name = "Fecha_Publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    @Column(name = "Descripcion", nullable = false, columnDefinition = "TEXT")
    private String descripcion;

    public Publicacion() {}

    public Publicacion(Integer id, Propiedad propiedad, Usuario usuario, String estado, LocalDate fechaPublicacion, String descripcion) {
        this.id = id;
        this.propiedad = propiedad;
        this.usuario = usuario;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
    }

    // GETTERS y SETTERS

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Propiedad getPropiedad() { return propiedad; }
    public void setPropiedad(Propiedad propiedad) { this.propiedad = propiedad; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
