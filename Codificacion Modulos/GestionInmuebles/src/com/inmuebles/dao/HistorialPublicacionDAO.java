package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.HistorialPublicacion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistorialPublicacionDAO {

    public boolean insertar(HistorialPublicacion h) {
        String sql = "INSERT INTO Historial_Publicacion (ID_Cliente, ID_Publicacion, Fecha_Interaccion) VALUES (?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, h.getIdCliente());
            stmt.setInt(2, h.getIdPublicacion());
            stmt.setDate(3, h.getFechaInteraccion());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando historial: " + e.getMessage());
            return false;
        }
    }

    public List<HistorialPublicacion> listar() {
        List<HistorialPublicacion> lista = new ArrayList<>();
        String sql = "SELECT * FROM Historial_Publicacion";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                HistorialPublicacion h = new HistorialPublicacion(
                        rs.getInt("ID_Historial"),
                        rs.getInt("ID_Cliente"),
                        rs.getInt("ID_Publicacion"),
                        rs.getDate("Fecha_Interaccion")
                );
                lista.add(h);
            }

        } catch (SQLException e) {
            System.out.println("Error listando historial: " + e.getMessage());
        }
        return lista;
    }

    public HistorialPublicacion buscarPorId(int id) {
        String sql = "SELECT * FROM Historial_Publicacion WHERE ID_Historial=?";
        HistorialPublicacion h = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                h = new HistorialPublicacion(
                        rs.getInt("ID_Historial"),
                        rs.getInt("ID_Cliente"),
                        rs.getInt("ID_Publicacion"),
                        rs.getDate("Fecha_Interaccion")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando historial: " + e.getMessage());
        }
        return h;
    }

    public boolean actualizar(HistorialPublicacion h) {
        String sql = "UPDATE Historial_Publicacion SET ID_Cliente=?, ID_Publicacion=?, Fecha_Interaccion=? WHERE ID_Historial=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, h.getIdCliente());
            stmt.setInt(2, h.getIdPublicacion());
            stmt.setDate(3, h.getFechaInteraccion());
            stmt.setInt(4, h.getIdHistorial());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando historial: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Historial_Publicacion WHERE ID_Historial=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando historial: " + e.getMessage());
            return false;
        }
    }
}
