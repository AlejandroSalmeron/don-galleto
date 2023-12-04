/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package org.utl.idgs.cuidador.controller;

import java.sql.SQLException;
import org.utl.idgs.donGalleto.Galleta;
import org.utl.idgs.donGalleto.Ingrediente;

/**
 *
 * @author yahir
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        //insertarGalleta();
        //actualizarGalleta();
        obtenerGalleta();
        //insertarIngrediente();
        //actualizarIngrediente();
        //obtenerIngrediente();
    }

    public static void insertarGalleta() throws SQLException {
        ControllerGalleta c = new ControllerGalleta();
        Galleta g = new Galleta("Chocolate", 100, 10, "Se terminaron");
        c.insertarGalleta(g);
    }

    public static void actualizarGalleta() throws SQLException {
        ControllerGalleta c = new ControllerGalleta();
        Galleta g = new Galleta(1, "Chocolate", 100, 10, "Se terminaron");
        c.actualizarGalleta(g);
    }

    public static void obtenerGalleta() throws SQLException {
        ControllerGalleta c = new ControllerGalleta();
        Galleta g = new Galleta();
        g.setId_galleta(1);
       // c.obtenerDatosGalleta(g.getId_galleta());
    }

    public static void insertarIngrediente() throws SQLException {
        ControllerIngrediente c = new ControllerIngrediente();
        Ingrediente i = new Ingrediente("Azucar", 10, "kilos");
        c.insertarIngrediente(i);
    }

    public static void actualizarIngrediente() throws SQLException {
        ControllerIngrediente c = new ControllerIngrediente();
        Ingrediente i = new Ingrediente(1,"Harina", 10, "kilos");
        c.actualizarIngrediente(i);
    }

    public static void obtenerIngrediente() throws SQLException {
        ControllerIngrediente c = new ControllerIngrediente();
        Ingrediente i = new Ingrediente();
        i.setId_ingrediente(1);
        c.obtenerDatosIngrediente(i.getId_ingrediente());
    }

}
