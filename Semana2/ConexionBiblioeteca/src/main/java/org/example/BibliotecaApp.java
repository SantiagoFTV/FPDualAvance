package org.example;

import java.sql.*;

public class BibliotecaApp {
    public static void main(String[] args) {
        String consulta = """
            SELECT c.Nombre AS Cliente, l.Titulo AS Libro, p.Fecha
            FROM Prestamos p
            JOIN Clientes c ON p.IdCliente = c.IdCliente
            JOIN PrestamoLibro pl ON p.IdPrestamo = pl.IdPrestamo
            JOIN Libros l ON pl.IdLibro = l.IdLibro
            ORDER BY p.Fecha;
        """;

        try (Connection conn = ConexionBD.obtenerConexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            System.out.println("📚 Libros prestados:");
            while (rs.next()) {
                String cliente = rs.getString("Cliente");
                String libro = rs.getString("Libro");
                Date fecha = rs.getDate("Fecha");
                System.out.printf("→ %s pidió \"%s\" el %s%n", cliente, libro, fecha);
            }

        } catch (SQLException e) {
            System.err.println(" Error al ejecutar la consulta: " + e.getMessage());
        }
    }
}
