package com.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoDAO {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=FacturaYGastos;encrypt=false";
    private final String user = "CESDE";
    private final String password = "1230";

    public void insertar(Gasto g) {
        String sql = "INSERT INTO Gastos (descripcion, valor, fecha, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, g.getDescripcion());
            stmt.setDouble(2, g.getValor());
            stmt.setString(3, g.getFecha());
            stmt.setString(4, "General");
            stmt.executeUpdate();
            System.out.println("✅ Gasto insertado en BD.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar gasto: " + e.getMessage());
        }
    }

    public List<Gasto> listar() {
        List<Gasto> lista = new ArrayList<>();
        String sql = "SELECT id_gasto, descripcion, valor, fecha FROM Gastos";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Gasto g = new Gasto(rs.getString("descripcion"), rs.getDouble("valor"), rs.getString("fecha"));
                g.setId(rs.getInt("id_gasto"));
                lista.add(g);
            }
        } catch (SQLException e) {
            System.out.println("❌ Error al listar gastos: " + e.getMessage());
        }
        return lista;
    }

    public void actualizar(Gasto g) {
        String sql = "UPDATE Gastos SET descripcion = ?, valor = ?, fecha = ? WHERE id_gasto = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, g.getDescripcion());
            stmt.setDouble(2, g.getValor());
            stmt.setString(3, g.getFecha());
            stmt.setInt(4, g.getId());
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? "✅ Gasto actualizado." : "⚠️ Gasto no encontrado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar gasto: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Gastos WHERE id_gasto = ?";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();
            System.out.println(filas > 0 ? "✅ Gasto eliminado." : "⚠️ Gasto no encontrado.");
        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar gasto: " + e.getMessage());
        }
    }
}
