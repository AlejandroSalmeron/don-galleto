/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.cuidador.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import org.utl.idgs.db.ConexionMySQL;
import org.utl.idgs.donGalleto.Galleta;

/**
 *
 * @author yahir
 */
public class ControllerGalleta {

    public int insertarGalleta(Galleta galleta) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call insertarGalleta(?,?,?,?,?)}";

        //2. Preparamos las variables para recibir los valores de retorno
        int id_galletaG = 0;

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, galleta.getNombre_galleta());
        cstmt.setInt(2, galleta.getCantidad_producida());
        cstmt.setDouble(3, galleta.getPrecio_galleta());
        cstmt.setString(4, galleta.getComentario());
        cstmt.registerOutParameter(5, Types.INTEGER);

        //6. Ejecutar la sentencia
        cstmt.executeUpdate();

        //7.Recuperar los parametros de rotorno
        id_galletaG = cstmt.getInt(5);

        //8. Colocar los valores recuperados dentro del objeto
        galleta.setId_galleta(id_galletaG);

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

        //10. Devolver el id que se genero
        return id_galletaG;
    }

    public void actualizarGalleta(Galleta galleta) throws SQLException {
        //1. Generar la consulta que vamos a enviar a la base de datos
        String query = "{call actualizarGalleta(?,?,?,?,?)}";

        //3. Conectarse a la base de Datos
        ConexionMySQL objConexionMySQL = new ConexionMySQL();
        Connection conn = objConexionMySQL.open();

        //4. Generar el objeto que va a invocar el Store Procedure
        CallableStatement cstmt = conn.prepareCall(query);

        //5.Asignar cada uno de los valores que se requiere
        cstmt.setString(1, galleta.getNombre_galleta());
        cstmt.setInt(2, galleta.getCantidad_producida());
        cstmt.setDouble(3, galleta.getPrecio_galleta());
        cstmt.setString(4, galleta.getComentario());
        cstmt.setInt(5, galleta.getId_galleta());

        cstmt.executeUpdate();

        //9. Cerrar los objetos de uso de BD
        cstmt.close();
        conn.close();
        objConexionMySQL.close();

    }

    public Galleta obtenerDatosGalleta(int id) throws SQLException {
        String query = "SELECT * FROM galleta WHERE id_galleta='" + id + "'";

        ConexionMySQL mySQL = new ConexionMySQL();
        Connection coon = mySQL.open();

        Statement stmn = coon.createStatement();
        ResultSet rs = stmn.executeQuery(query);

        Galleta galleta = null;

        if (rs.next()) {
            galleta = fillGalleta(rs);
        }
        rs.close();
        stmn.close();
        coon.close();
        mySQL.close();
       System.out.println(galleta);
        return galleta;

    }

    
       public List <Galleta> getAllGalletas() throws SQLException {
        String query = "SELECT * FROM galleta";

         ConexionMySQL sql = new ConexionMySQL();

        Connection conn = sql.open();

        PreparedStatement pstmt = conn.prepareStatement(query);

        ResultSet rs = pstmt.executeQuery();
        List<Galleta> lisg = new ArrayList<>();

        while (rs.next()) {
            lisg.add(fillGalleta(rs));
        }
        rs.close();
        pstmt.close();
        sql.close();
        System.out.println(lisg);
        return lisg;

    }
    private Galleta fillGalleta(ResultSet rs) throws SQLException {
        //Creamos un Objeto de Tipo empleado
        Galleta g = new Galleta();

        g.setId_galleta(rs.getInt("id_galleta"));
        g.setNombre_galleta(rs.getString("nombre_galleta"));
        g.setCantidad_producida(rs.getInt("cantidad_producida"));
        g.setPrecio_galleta(rs.getDouble("precio_galleta"));
        g.setComentario(rs.getString("comentario"));

        return g;
    }
}
