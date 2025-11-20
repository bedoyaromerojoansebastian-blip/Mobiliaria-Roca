package com.inmuebles.modelo;

import java.sql.Date;

public class Contrato {

    private int idContrato;
    private Date fechaInicio;
    private Date fechaFin;
    private String terminos;
    private int idCompra;

    public Contrato() {}

    public Contrato(int idContrato, Date fechaInicio, Date fechaFin, String terminos, int idCompra) {
        this.idContrato = idContrato;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.terminos = terminos;
        this.idCompra = idCompra;
    }

    public int getIdContrato() { return idContrato; }
    public void setIdContrato(int idContrato) { this.idContrato = idContrato; }

    public Date getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(Date fechaInicio) { this.fechaInicio = fechaInicio; }

    public Date getFechaFin() { return fechaFin; }
    public void setFechaFin(Date fechaFin) { this.fechaFin = fechaFin; }

    public String getTerminos() { return terminos; }
    public void setTerminos(String terminos) { this.terminos = terminos; }

    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    @Override
    public String toString() {
        return "Contrato {" +
                "ID=" + idContrato +
                ", Inicio=" + fechaInicio +
                ", Fin=" + fechaFin +
                ", Términos='" + terminos + '\'' +
                ", ID_Compra=" + idCompra +
                '}';
    }
}

