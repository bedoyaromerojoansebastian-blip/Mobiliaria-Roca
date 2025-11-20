package com.inmuebles.modelo;

import java.sql.Date;

public class Compra {

    private int idCompra;
    private Date fecha;
    private double monto;
    private int idCliente;
    private int idPropiedad;

    public Compra() {}

    public Compra(int idCompra, Date fecha, double monto, int idCliente, int idPropiedad) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.monto = monto;
        this.idCliente = idCliente;
        this.idPropiedad = idPropiedad;
    }

    public int getIdCompra() { return idCompra; }
    public void setIdCompra(int idCompra) { this.idCompra = idCompra; }

    public Date getFecha() { return fecha; }
    public void setFecha(Date fecha) { this.fecha = fecha; }

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public int getIdPropiedad() { return idPropiedad; }
    public void setIdPropiedad(int idPropiedad) { this.idPropiedad = idPropiedad; }

    @Override
    public String toString() {
        return "Compra {" +
                "ID=" + idCompra +
                ", Fecha=" + fecha +
                ", Monto=" + monto +
                ", ID_Cliente=" + idCliente +
                ", ID_Propiedad=" + idPropiedad +
                '}';
    }
}
