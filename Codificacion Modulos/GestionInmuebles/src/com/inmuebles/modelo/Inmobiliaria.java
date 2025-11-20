package com.inmuebles.modelo;

public class Inmobiliaria {

    private int idInmobiliaria;
    private String nombre;
    private String direccion;
    private String telefono;
    private int idUsuario;

    public Inmobiliaria() {
    }

    public Inmobiliaria(int idInmobiliaria, String nombre, String direccion, String telefono, int idUsuario) {
        this.idInmobiliaria = idInmobiliaria;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }

    public int getIdInmobiliaria() {
        return idInmobiliaria;
    }

    public void setIdInmobiliaria(int idInmobiliaria) {
        this.idInmobiliaria = idInmobiliaria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public String toString() {
        return "Inmobiliaria {" +
                "ID=" + idInmobiliaria +
                ", Nombre='" + nombre + '\'' +
                ", Dirección='" + direccion + '\'' +
                ", Teléfono='" + telefono + '\'' +
                ", ID_Usuario=" + idUsuario +
                '}';
    }
}
