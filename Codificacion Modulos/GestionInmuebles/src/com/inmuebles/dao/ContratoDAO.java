package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Contrato;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContratoDAO {

    public boolean insertar(Contrato c) {
        String sql = "INSERT INTO Contrato (Fecha_inicio, Fecha_fin, Terminos, ID_Compra) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, c.getFechaInicio());
            stmt.setDate(2, c.getFechaFin());
            stmt.setString(3, c.getTerminos());
            stmt.setInt(4, c.getIdCompra());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando contrato: " + e.getMessage());
            return false;
        }
    }

    public List<Contrato> listar() {
        List<Contrato> lista = new ArrayList<>();
        String sql = "SELECT * FROM Contrato";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Contrato c = new Contrato(
                        rs.getInt("ID_Contrato"),
                        rs.getDate("Fecha_inicio"),
                        rs.getDate("Fecha_fin"),
                        rs.getString("Terminos"),
                        rs.getInt("ID_Compra")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error listando contratos: " + e.getMessage());
        }
        return lista;
    }

    public Contrato buscarPorId(int id) {
        String sql = "SELECT * FROM Contrato WHERE ID_Contrato=?";
        Contrato c = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Contrato(
                        rs.getInt("ID_Contrato"),
                        rs.getDate("Fecha_inicio"),
                        rs.getDate("Fecha_fin"),
                        rs.getString("Terminos"),
                        rs.getInt("ID_Compra")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando contrato: " + e.getMessage());
        }
        return c;
    }

    public boolean actualizar(Contrato c) {
        String sql = "UPDATE Contrato SET Fecha_inicio=?, Fecha_fin=?, Terminos=?, ID_Compra=? WHERE ID_Contrato=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, c.getFechaInicio());
            stmt.setDate(2, c.getFechaFin());
            stmt.setString(3, c.getTerminos());
            stmt.setInt(4, c.getIdCompra());
            stmt.setInt(5, c.getIdContrato());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando contrato: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Contrato WHERE ID_Contrato=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando contrato: " + e.getMessage());
            return false;
        }
    }
}

