package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Compra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraDAO {

    public boolean insertar(Compra c) {
        String sql = "INSERT INTO Compra (Fecha, Monto, ID_Cliente, ID_Propiedad) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, c.getFecha());
            stmt.setDouble(2, c.getMonto());
            stmt.setInt(3, c.getIdCliente());
            stmt.setInt(4, c.getIdPropiedad());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando compra: " + e.getMessage());
            return false;
        }
    }

    public List<Compra> listar() {
        List<Compra> lista = new ArrayList<>();
        String sql = "SELECT * FROM Compra";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Compra c = new Compra(
                        rs.getInt("ID_Compra"),
                        rs.getDate("Fecha"),
                        rs.getDouble("Monto"),
                        rs.getInt("ID_Cliente"),
                        rs.getInt("ID_Propiedad")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error listando compras: " + e.getMessage());
        }
        return lista;
    }

    public Compra buscarPorId(int id) {
        String sql = "SELECT * FROM Compra WHERE ID_Compra=?";
        Compra c = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Compra(
                        rs.getInt("ID_Compra"),
                        rs.getDate("Fecha"),
                        rs.getDouble("Monto"),
                        rs.getInt("ID_Cliente"),
                        rs.getInt("ID_Propiedad")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando compra: " + e.getMessage());
        }
        return c;
    }

    public boolean actualizar(Compra c) {
        String sql = "UPDATE Compra SET Fecha=?, Monto=?, ID_Cliente=?, ID_Propiedad=? WHERE ID_Compra=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setDate(1, c.getFecha());
            stmt.setDouble(2, c.getMonto());
            stmt.setInt(3, c.getIdCliente());
            stmt.setInt(4, c.getIdPropiedad());
            stmt.setInt(5, c.getIdCompra());

            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando compra: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Compra WHERE ID_Compra=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando compra: " + e.getMessage());
            return false;
        }
    }
}

