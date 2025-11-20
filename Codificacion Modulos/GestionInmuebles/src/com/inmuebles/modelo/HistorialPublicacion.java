package com.inmuebles.modelo;

import java.sql.Date;

public class HistorialPublicacion {

    private int idHistorial;
    private int idCliente;
    private int idPublicacion;
    private Date fechaInteraccion;

    public HistorialPublicacion() {}

    public HistorialPublicacion(int idHistorial, int idCliente, int idPublicacion, Date fechaInteraccion) {
        this.idHistorial = idHistorial;
        this.idCliente = idCliente;
        this.idPublicacion = idPublicacion;
        this.fechaInteraccion = fechaInteraccion;
    }

    public int getIdHistorial() { return idHistorial; }
    public void setIdHistorial(int idHistorial) { this.idHistorial = idHistorial; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdPublicacion() { return idPublicacion; }
    public void setIdPublicacion(int idPublicacion) { this.idPublicacion = idPublicacion; }

    public Date getFechaInteraccion() { return fechaInteraccion; }
    public void setFechaInteraccion(Date fechaInteraccion) { this.fechaInteraccion = fechaInteraccion; }

    @Override
    public String toString() {
        return "HistorialPublicacion {" +
                "ID=" + idHistorial +
                ", ID_Cliente=" + idCliente +
                ", ID_Publicacion=" + idPublicacion +
                ", Fecha='" + fechaInteraccion + '\'' +
                '}';
    }
}
