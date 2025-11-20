package com.inmuebles.modelo;

public class Propiedad {

    private int idPropiedad;
    private String tipo;
    private String ubicacion;
    private double precio;
    private int habitaciones;
    private int idPropietario;
    private int idInmobiliaria;

    public Propiedad() {}

    public Propiedad(int idPropiedad, String tipo, String ubicacion, double precio, int habitaciones,
                     int idPropietario, int idInmobiliaria) {
        this.idPropiedad = idPropiedad;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.precio = precio;
        this.habitaciones = habitaciones;
        this.idPropietario = idPropietario;
        this.idInmobiliaria = idInmobiliaria;
    }

    public int getIdPropiedad() { return idPropiedad; }
    public void setIdPropiedad(int idPropiedad) { this.idPropiedad = idPropiedad; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }

    public int getHabitaciones() { return habitaciones; }
    public void setHabitaciones(int habitaciones) { this.habitaciones = habitaciones; }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public int getIdInmobiliaria() { return idInmobiliaria; }
    public void setIdInmobiliaria(int idInmobiliaria) { this.idInmobiliaria = idInmobiliaria; }

    @Override
    public String toString() {
        return "Propiedad {" +
                "ID=" + idPropiedad +
                ", Tipo='" + tipo + '\'' +
                ", Ubicación='" + ubicacion + '\'' +
                ", Precio=" + precio +
                ", Habitaciones=" + habitaciones +
                ", ID_Propietario=" + idPropietario +
                ", ID_Inmobiliaria=" + idInmobiliaria +
                '}';
    }
}
