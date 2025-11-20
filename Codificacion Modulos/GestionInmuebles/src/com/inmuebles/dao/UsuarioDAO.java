package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    // INSERTAR
    public boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO Usuario (Correo, Contrasena, Tipo_usuario) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getTipoUsuario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando usuario: " + e.getMessage());
            return false;
        }
    }

    // LISTAR
    public List<Usuario> listar() {
        List<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Usuario u = new Usuario(
                        rs.getInt("ID_Usuario"),
                        rs.getString("Correo"),
                        rs.getString("Contrasena"),
                        rs.getString("Tipo_usuario")
                );
                lista.add(u);
            }
        } catch (SQLException e) {
            System.out.println("Error listando usuarios: " + e.getMessage());
        }
        return lista;
    }

    // BUSCAR POR ID
    public Usuario buscarPorId(int id) {
        String sql = "SELECT * FROM Usuario WHERE ID_Usuario = ?";
        Usuario u = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                u = new Usuario(
                        rs.getInt("ID_Usuario"),
                        rs.getString("Correo"),
                        rs.getString("Contrasena"),
                        rs.getString("Tipo_usuario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando usuario: " + e.getMessage());
        }
        return u;
    }

    // ACTUALIZAR
    public boolean actualizar(Usuario usuario) {
        String sql = "UPDATE Usuario SET Correo=?, Contrasena=?, Tipo_usuario=? WHERE ID_Usuario=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, usuario.getCorreo());
            stmt.setString(2, usuario.getContrasena());
            stmt.setString(3, usuario.getTipoUsuario());
            stmt.setInt(4, usuario.getIdUsuario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando usuario: " + e.getMessage());
            return false;
        }
    }

    // ELIMINAR
    public boolean eliminar(int id) {
        String sql = "DELETE FROM Usuario WHERE ID_Usuario=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando usuario: " + e.getMessage());
            return false;
        }
    }
}

