package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Propiedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PropiedadDAO {

    public boolean insertar(Propiedad p) {
        String sql = "INSERT INTO Propiedad (Tipo, Ubicacion, Precio, Habitaciones, ID_Propietario, ID_Inmobiliaria) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getTipo());
            stmt.setString(2, p.getUbicacion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getHabitaciones());
            stmt.setInt(5, p.getIdPropietario());
            stmt.setInt(6, p.getIdInmobiliaria());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando propiedad: " + e.getMessage());
            return false;
        }
    }

    public List<Propiedad> listar() {
        List<Propiedad> lista = new ArrayList<>();
        String sql = "SELECT * FROM Propiedad";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Propiedad p = new Propiedad(
                        rs.getInt("ID_Propiedad"),
                        rs.getString("Tipo"),
                        rs.getString("Ubicacion"),
                        rs.getDouble("Precio"),
                        rs.getInt("Habitaciones"),
                        rs.getInt("ID_Propietario"),
                        rs.getInt("ID_Inmobiliaria")
                );
                lista.add(p);
            }

        } catch (SQLException e) {
            System.out.println("Error listando propiedades: " + e.getMessage());
        }
        return lista;
    }

    public Propiedad buscarPorId(int id) {
        String sql = "SELECT * FROM Propiedad WHERE ID_Propiedad=?";
        Propiedad p = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                p = new Propiedad(
                        rs.getInt("ID_Propiedad"),
                        rs.getString("Tipo"),
                        rs.getString("Ubicacion"),
                        rs.getDouble("Precio"),
                        rs.getInt("Habitaciones"),
                        rs.getInt("ID_Propietario"),
                        rs.getInt("ID_Inmobiliaria")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando propiedad: " + e.getMessage());
        }
        return p;
    }

    public boolean actualizar(Propiedad p) {
        String sql = "UPDATE Propiedad SET Tipo=?, Ubicacion=?, Precio=?, Habitaciones=?, ID_Propietario=?, ID_Inmobiliaria=? WHERE ID_Propiedad=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getTipo());
            stmt.setString(2, p.getUbicacion());
            stmt.setDouble(3, p.getPrecio());
            stmt.setInt(4, p.getHabitaciones());
            stmt.setInt(5, p.getIdPropietario());
            stmt.setInt(6, p.getIdInmobiliaria());
            stmt.setInt(7, p.getIdPropiedad());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando propiedad: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Propiedad WHERE ID_Propiedad=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando propiedad: " + e.getMessage());
            return false;
        }
    }
}
