package com.inmuebles.dao;

import com.inmuebles.conexion.Conexion;
import com.inmuebles.modelo.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean insertar(Cliente c) {
        String sql = "INSERT INTO Cliente (Nombre, Correo, Telefono, ID_Usuario) VALUES (?, ?, ?, ?)";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getCorreo());
            stmt.setString(3, c.getTelefono());
            stmt.setInt(4, c.getIdUsuario());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error insertando cliente: " + e.getMessage());
            return false;
        }
    }

    public List<Cliente> listar() {
        List<Cliente> lista = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";

        try (Connection conn = Conexion.conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Cliente c = new Cliente(
                        rs.getInt("ID_Cliente"),
                        rs.getString("Nombre"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("ID_Usuario")
                );
                lista.add(c);
            }

        } catch (SQLException e) {
            System.out.println("Error listando clientes: " + e.getMessage());
        }
        return lista;
    }

    public Cliente buscarPorId(int id) {
        String sql = "SELECT * FROM Cliente WHERE ID_Cliente=?";
        Cliente c = null;

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                c = new Cliente(
                        rs.getInt("ID_Cliente"),
                        rs.getString("Nombre"),
                        rs.getString("Correo"),
                        rs.getString("Telefono"),
                        rs.getInt("ID_Usuario")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error buscando cliente: " + e.getMessage());
        }
        return c;
    }

    public boolean actualizar(Cliente c) {
        String sql = "UPDATE Cliente SET Nombre=?, Correo=?, Telefono=?, ID_Usuario=? WHERE ID_Cliente=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getCorreo());
            stmt.setString(3, c.getTelefono());
            stmt.setInt(4, c.getIdUsuario());
            stmt.setInt(5, c.getIdCliente());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error actualizando cliente: " + e.getMessage());
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM Cliente WHERE ID_Cliente=?";

        try (Connection conn = Conexion.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("Error eliminando cliente: " + e.getMessage());
            return false;
        }
    }
}

