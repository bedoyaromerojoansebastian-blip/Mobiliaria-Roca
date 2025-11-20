package com.inmuebles.inmobiliaria.entity;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Usuario")
    private Integer idUsuario;

    @Column(name = "Correo", nullable = false, unique = true, length = 100)
    private String correo;

    @Column(name = "Contrasena", nullable = false, length = 100)
    private String contrasena;

    @Enumerated(EnumType.STRING)
    @Column(name = "Tipo_usuario", nullable = false, length = 20)
    private TipoUsuario tipoUsuario;

    @JsonIgnore
    @OneToMany(mappedBy = "usuario")
    private List<Inmobiliaria> inmobiliarias;

    public enum TipoUsuario {
        Administrador, Cliente, Propietario, Inmobiliaria
    }

    // getters y setters
    public Integer getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Integer idUsuario) { this.idUsuario = idUsuario; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }
    public String getContrasena() { return contrasena; }
    public void setContrasena(String contrasena) { this.contrasena = contrasena; }
    public TipoUsuario getTipoUsuario() { return tipoUsuario; }
    public void setTipoUsuario(TipoUsuario tipoUsuario) { this.tipoUsuario = tipoUsuario; }

    public List<Inmobiliaria> getInmobiliarias() { return inmobiliarias; }
    public void setInmobiliarias(List<Inmobiliaria> inmobiliarias) { this.inmobiliarias = inmobiliarias; }
}

