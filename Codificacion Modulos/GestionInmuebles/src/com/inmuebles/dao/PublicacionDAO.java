package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Publicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PublicacionDAO {

    public boolean insertar(Publicacion p) {
        String sql = "INSERT INTO Publicacion (ID_Propiedad, ID_Usuario, Estado, Fecha_Publicacion, Descripcion) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdPropiedad());
            stmt.setInt(2, p.getIdUsuario());
            stmt.setString(3, p.getEstado());
            stmt.setDate(4, p.getFechaPublicacion());
            stmt.setString(5, p.getDescripcion());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando publicación: " + e.getMessage());
            return false;
        }
    }

    public List<Publicacion> listar() {
        List<Publicacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Publicacion";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Publicacion p = new Publicacion(
                        rs.getInt("ID_Publicacion"),
                        rs.getInt("ID_Propiedad"),
                        rs.getInt("ID_Usuario"),
                        rs.getString("Estado"),
                        rs.getDate("Fecha_Publicacion"),
                        rs.getString("Descripcion")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error listando publicaciones: " + e.getMessage());
        }
        return lista;
    }

    public Publicacion buscarPorId(int id) {
        String sql = "SELECT * FROM Publicacion WHERE ID_Publicacion=?";
        Publicacion p = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new Publicacion(
                        rs.getInt("ID_Publicacion"),
                        rs.getInt("ID_Propiedad"),
                        rs.getInt("ID_Usuario"),
                        rs.getString("Estado"),
                        rs.getDate("Fecha_Publicacion"),
                        rs.getString("Descripcion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando publicación: " + e.getMessage());
        }
        return p;
    }

    public boolean actualizar(Publicacion p) {
        String sql = "UPDATE Publicacion SET ID_Propiedad=?, ID_Usuario=?, Estado=?, Fecha_Publicacion=?, Descripcion=? WHERE ID_Publicacion=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, p.getIdPropiedad());
            stmt.setInt(2, p.getIdUsuario());
            stmt.setString(3, p.getEstado());
            stmt.setDate(4, p.getFechaPublicacion());
            stmt.setString(5, p.getDescripcion());
            stmt.setInt(6, p.getIdPublicacion());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando publicación: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Publicacion WHERE ID_Publicacion=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando publicación: " + e.getMessage());
            return false;
        }
    }
}

