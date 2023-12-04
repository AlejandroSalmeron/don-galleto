/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.cuidador.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import org.utl.idgs.db.ConexionMySQL;
import org.utl.idgs.donGalleto.Ingrediente;

/**
 *
 * @author yahir
 */
public class ControllerIngrediente {
        public int insertarIngrediente(Ingrediente ingrediente) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call insertarIngrediente(?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int id_ingredienteG = 0;

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, ingrediente.getNombre_ingrediente());
        cstmt.setDouble(2, ingrediente.getCantidad());
        cstmt.setString(3, ingrediente.getUnidad_medida());
        cstmt.registerOutParameter(4, Types.INTEGER);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        id_ingredienteG = cstmt.getInt(4);

        //8. Colocar los valores recuperados dentro del objeto
        ingrediente.setId_ingrediente(id_ingredienteG);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return id_ingredienteG;
    }

    public void actualizarIngrediente(Ingrediente ingrediente) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call actualizarIngrediente(?,?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, ingrediente.getNombre_ingrediente());
        cstmt.setDouble(2, ingrediente.getCantidad());
        cstmt.setString(3, ingrediente.getUnidad_medida());
        cstmt.setInt(4, ingrediente.getId_ingrediente());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public Ingrediente obtenerDatosIngrediente(int id) throws SQLException {
        String query = "SELECT * FROM ingredientes WHERE id_ingrediente='" + id + "'";

        ConexionMySQL mySQL = new ConexionMySQL();
        Connection coon = mySQL.open();

        Statement stmn = coon.createStatement();
        ResultSet rs = stmn.executeQuery(query);

        Ingrediente ingrediente = null;

        if (rs.next()) {
            ingrediente = fillIngrediente(rs);
        }
        rs.close();
        stmn.close();
        coon.close();
        mySQL.close();
       //System.out.println(ingrediente);
        return ingrediente;

    }

    private Ingrediente fillIngrediente(ResultSet rs) throws SQLException {
        //Creamos un Objeto de Tipo empleado
        Ingrediente i = new Ingrediente();
        
        i.setId_ingrediente(rs.getInt("id_ingrediente"));
        i.setNombre_ingrediente(rs.getString("nombre_ingrediente"));
        i.setCantidad(rs.getDouble("cantidad"));
        i.setUnidad_medida(rs.getString("unidad_medida"));

        return i;
    }
}
