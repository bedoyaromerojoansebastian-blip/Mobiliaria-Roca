package com.inmuebles.modelo;

public class Cliente {
    private int idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private int idUsuario;

    public Cliente() {}

    public Cliente(int idCliente, String nombre, String correo, String telefono, int idUsuario) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    @Override
    public String toString() {
        return "Cliente {" +
                "ID=" + idCliente +
                ", Nombre='" + nombre + '\'' +
                ", Correo='" + correo + '\'' +
                ", Telefono='" + telefono + '\'' +
                ", ID_Usuario=" + idUsuario +
                '}';
    }
}
