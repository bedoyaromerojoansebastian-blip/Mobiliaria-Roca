package com.inmuebles.modelo;

import java.sql.Date;

public class Publicacion {

    private int idPublicacion;
    private int idPropiedad;
    private int idUsuario;
    private String estado;
    private Date fechaPublicacion;
    private String descripcion;

    public Publicacion() {}

    public Publicacion(int idPublicacion, int idPropiedad, int idUsuario, String estado,
                       Date fechaPublicacion, String descripcion) {
        this.idPublicacion = idPublicacion;
        this.idPropiedad = idPropiedad;
        this.idUsuario = idUsuario;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
        this.descripcion = descripcion;
    }

    public int getIdPublicacion() { return idPublicacion; }
    public void setIdPublicacion(int idPublicacion) { this.idPublicacion = idPublicacion; }

    public int getIdPropiedad() { return idPropiedad; }
    public void setIdPropiedad(int idPropiedad) { this.idPropiedad = idPropiedad; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(Date fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    @Override
    public String toString() {
        return "Publicacion {" +
                "ID=" + idPublicacion +
                ", ID_Propiedad=" + idPropiedad +
                ", ID_Usuario=" + idUsuario +
                ", Estado='" + estado + '\'' +
                ", Fecha=" + fechaPublicacion +
                ", Descripción='" + descripcion + '\'' +
                '}';
    }
}
