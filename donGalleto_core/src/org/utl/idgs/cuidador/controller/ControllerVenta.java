/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.cuidador.controller;
import java.sql.ResultSet;
/**
 *
 * @author yahir
 */

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import org.utl.idgs.db.ConexionMySQL;
import org.utl.idgs.donGalleto.Venta;

public class ControllerVenta  {

    // Método para insertar datos en la tabla venta
    public void insertarVenta(Venta venta) throws SQLException {
        // Datos de conexión a tu base de datos MySQL
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        // Query para la inserción con la fecha y hora automática
        String sql = "INSERT INTO venta (total, comentario) VALUES (?, ?)";

       
            PreparedStatement pstmt = conn.prepareStatement(sql);
        
            // Establecer los valores para los parámetros
            pstmt.setDouble(1, venta.getTotal());
            pstmt.setString(2, venta.getComentario());
             
            // Ejecutar la inserción
            pstmt.executeUpdate();
            System.out.println("Registro insertado correctamente.");
        
    }


    // Constructor que recibe la conexión a la base de datos
    

    public double obtenerTotalPorFechaHora() throws SQLException {
        double total = 0;
ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();
        // Consulta SQL para obtener el total de ventas para una fecha_hora específica
        String query = "SELECT SUM(total) AS total_ventas FROM venta";

        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
           

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    total = rs.getDouble("total_ventas");
                }
                System.out.println(total);
            }
        }
return total;
        }
    

    // Método main para probar la inserción
    public static void main(String[] args) throws SQLException {
        // Crear una instancia del controlador de venta
        ControllerVenta  controller = new ControllerVenta();
        Venta venta=new Venta("rara", 1.2);
        // Insertar una nueva venta con valores
        controller.obtenerTotalPorFechaHora();
        
    }
}


