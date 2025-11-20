package com.inmuebles.modelo;

public class Propietario {

    private int idPropietario;
    private String nombre;
    private String telefono;
    private String correo;
    private int idUsuario;

    public Propietario() {}

    public Propietario(int idPropietario, String nombre, String telefono, String correo, int idUsuario) {
        this.idPropietario = idPropietario;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.idUsuario = idUsuario;
    }

    public int getIdPropietario() { return idPropietario; }
    public void setIdPropietario(int idPropietario) { this.idPropietario = idPropietario; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }
}
