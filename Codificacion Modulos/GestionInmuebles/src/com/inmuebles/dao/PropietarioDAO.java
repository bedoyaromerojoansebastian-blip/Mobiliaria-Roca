package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Propietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropietarioDAO {

    public boolean insertar(Propietario p) {
        String sql = "INSERT INTO Propietario (Nombre, Telefono, Correo, ID_Usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getTelefono());
            stmt.setString(3, p.getCorreo());
            stmt.setInt(4, p.getIdUsuario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando propietario: " + e.getMessage());
            return false;
        }
    }

    public List<Propietario> listar() {
        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM Propietario";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Propietario p = new Propietario(
                        rs.getInt("ID_Propietario"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        rs.getInt("ID_Usuario")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error listando propietarios: " + e.getMessage());
        }
        return lista;
    }

    public Propietario buscarPorId(int id) {
        String sql = "SELECT * FROM Propietario WHERE ID_Propietario=?";
        Propietario p = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new Propietario(
                        rs.getInt("ID_Propietario"),
                        rs.getString("Nombre"),
                        rs.getString("Telefono"),
                        rs.getString("Correo"),
                        rs.getInt("ID_Usuario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando propietario: " + e.getMessage());
        }
        return p;
    }

    public boolean actualizar(Propietario p) {
        String sql = "UPDATE Propietario SET Nombre=?, Telefono=?, Correo=?, ID_Usuario=? WHERE ID_Propietario=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getTelefono());
            stmt.setString(3, p.getCorreo());
            stmt.setInt(4, p.getIdUsuario());
            stmt.setInt(5, p.getIdPropietario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando propietario: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Propietario WHERE ID_Propietario=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando propietario: " + e.getMessage());
            return false;
        }
    }
}
