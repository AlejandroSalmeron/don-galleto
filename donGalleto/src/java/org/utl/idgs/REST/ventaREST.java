/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.REST;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sun.jdi.connect.spi.Connection;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import org.utl.idgs.cuidador.controller.ControllerGalleta;
import org.utl.idgs.cuidador.controller.ControllerVenta;
import org.utl.idgs.db.ConexionMySQL;
import org.utl.idgs.donGalleto.Galleta;
import org.utl.idgs.donGalleto.Venta;

/**
 *
 * @author daian
 */
@Path("venta")
public class ventaREST {

    @Path("insertarVenta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarVenta(@FormParam("datos") @DefaultValue("") String datos) {
        
       Gson gson = new Gson();
        String out = "";

        Venta venta = new Venta();
        venta = gson.fromJson(datos, Venta.class);
        ControllerVenta cv = new ControllerVenta();

        try {
            cv.insertarVenta(venta);
            out = gson.toJson(venta);
        } catch (JsonParseException json) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
    @Path("ver")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obtenerTotalPorFechaHora() {
        
       String out = "";
        try {
            ControllerVenta ci = new ControllerVenta();
            double total = ci.obtenerTotalPorFechaHora();
            Gson gs = new Gson();
            out = gs.toJson(total);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    
    }
}