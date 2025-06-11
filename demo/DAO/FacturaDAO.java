package com.example.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacturaDAO {
    private final String url = "jdbc:sqlserver://localhost:1433;databaseName=FacturaYGastos;encrypt=false";
    private final String user = "CESDE"; 
    private final String password = "1230"; 

    public void insertar(Factura factura) {
        String sql = "INSERT INTO Documentos (nombre, descripcion, valor_total, id_tipo_documento, id_emisor, id_receptor, categoria_gasto) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "Factura desde App");
            stmt.setString(2, factura.getDescripcion());
            stmt.setDouble(3, factura.getValor());
            stmt.setInt(4, 1); // 1 = Factura
            stmt.setInt(5, 1); // ID emisor fijo
            stmt.setInt(6, 2); // ID receptor fijo
            stmt.setString(7, factura.getConsumidorFinal());

            stmt.executeUpdate();
            System.out.println("✅ Factura guardada en la base de datos.");
        } catch (SQLException e) {
            System.out.println("❌ Error al insertar factura: " + e.getMessage());
        }
    }

    public List<Factura> listar() {
        List<Factura> lista = new ArrayList<>();
        String sql = "SELECT id_documento, descripcion, valor_total, categoria_gasto FROM Documentos WHERE id_tipo_documento = 1";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id_documento");
                String descripcion = rs.getString("descripcion");
                double valor = rs.getDouble("valor_total");
                String consumidor = rs.getString("categoria_gasto");

                Factura factura = new Factura(descripcion, valor, false, "N/A", consumidor);
                factura.setId(id); // Necesitarás agregar setId en la clase Factura
                lista.add(factura);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al listar facturas: " + e.getMessage());
        }

        return lista;
    }

    public void actualizar(Factura factura) {
        String sql = "UPDATE Documentos SET descripcion = ?, valor_total = ?, categoria_gasto = ? WHERE id_documento = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, factura.getDescripcion());
            stmt.setDouble(2, factura.getValor());
            stmt.setString(3, factura.getConsumidorFinal());
            stmt.setInt(4, factura.getId());

            int filas = stmt.executeUpdate();
            if (filas > 0) {
                System.out.println("✅ Factura actualizada correctamente.");
            } else {
                System.out.println("⚠️ No se encontró la factura con ID: " + factura.getId());
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al actualizar factura: " + e.getMessage());
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM Documentos WHERE id_documento = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println("✅ Factura eliminada.");
            } else {
                System.out.println("⚠️ No se encontró la factura con ID: " + id);
            }

        } catch (SQLException e) {
            System.out.println("❌ Error al eliminar factura: " + e.getMessage());
        }
    }
}
