package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Inmobiliaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InmobiliariaDAO {

    public boolean insertar(Inmobiliaria i) {
        String sql = "INSERT INTO Inmobiliaria (Nombre, Direccion, Telefono, ID_Usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getDireccion());
            stmt.setString(3, i.getTelefono());
            stmt.setInt(4, i.getIdUsuario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando inmobiliaria: " + e.getMessage());
            return false;
        }
    }

    public List<Inmobiliaria> listar() {
        List<Inmobiliaria> lista = new ArrayList<>();
        String sql = "SELECT * FROM Inmobiliaria";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Inmobiliaria i = new Inmobiliaria(
                        rs.getInt("ID_Inmobiliaria"),
                        rs.getString("Nombre"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getInt("ID_Usuario")
                );
                lista.add(i);
            }

        } catch (SQLException e) {
            System.out.println("Error listando inmobiliarias: " + e.getMessage());
        }
        return lista;
    }

    public Inmobiliaria buscarPorId(int id) {
        String sql = "SELECT * FROM Inmobiliaria WHERE ID_Inmobiliaria=?";
        Inmobiliaria i = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                i = new Inmobiliaria(
                        rs.getInt("ID_Inmobiliaria"),
                        rs.getString("Nombre"),
                        rs.getString("Direccion"),
                        rs.getString("Telefono"),
                        rs.getInt("ID_Usuario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando inmobiliaria: " + e.getMessage());
        }
        return i;
    }

    public boolean actualizar(Inmobiliaria i) {
        String sql = "UPDATE Inmobiliaria SET Nombre=?, Direccion=?, Telefono=?, ID_Usuario=? WHERE ID_Inmobiliaria=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, i.getNombre());
            stmt.setString(2, i.getDireccion());
            stmt.setString(3, i.getTelefono());
            stmt.setInt(4, i.getIdUsuario());
            stmt.setInt(5, i.getIdInmobiliaria());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando inmobiliaria: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Inmobiliaria WHERE ID_Inmobiliaria=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando inmobiliaria: " + e.getMessage());
            return false;
        }
    }
}
