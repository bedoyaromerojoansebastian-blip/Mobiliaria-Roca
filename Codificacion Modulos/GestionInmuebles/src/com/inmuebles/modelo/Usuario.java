package com.inmuebles.modelo;

public class Usuario {
    private int idUsuario;
    private String correo;
    private String contrasena;
    private String tipoUsuario;

    public Usuario() {}

    public Usuario(int idUsuario, String correo, String contrasena, String tipoUsuario) {
        this.idUsuario = idUsuario;
        this.correo = correo;
        this.contrasena = contrasena;
        this.tipoUsuario = tipoUsuario;
    }

    public int getIdUsuario() { return idUsuario; }
    public void setIdUsuario(int idUsuario) { this.idUsuario = idUsuario; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }

    public String getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(String tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    @Override
    public String toString() {
        return "Usuario {" +
                "ID=" + idUsuario +
                ", Correo='" + correo + '\'' +
                ", Tipo='" + tipoUsuario + '\'' +
                '}';
    }
}
