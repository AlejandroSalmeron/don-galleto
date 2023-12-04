/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.REST;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.idgs.cuidador.controller.ControllerGalleta;
import org.utl.idgs.donGalleto.Galleta;

/**
 *
 * @author yahir
 */
@Path("galleta")
public class galletaREST extends Application {

    @Path("insertarGalleta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarGalleta(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        String out = "";

        Galleta galleta = new Galleta();
        galleta = gson.fromJson(datos, Galleta.class);
        ControllerGalleta cg = new ControllerGalleta();

        try {
            cg.insertarGalleta(galleta);
            out = gson.toJson(galleta);
        } catch (JsonParseException json) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }
    
    @Path("actualizarGalleta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarGalleta(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Galleta galleta = new Galleta();
        //El punto class es la especificacion que contiene la clase
        galleta = gson.fromJson(datos, Galleta.class);
        String out = "";
        ControllerGalleta mayor = new ControllerGalleta();
        try {
            mayor.actualizarGalleta(galleta);
            out = gson.toJson(galleta);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    
    @Path("getGalleta")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGalleta(@FormParam("id") @DefaultValue("") String id) {
        String out="";
        int id_gall = Integer.parseInt(id);
        try {
            ControllerGalleta cg = new ControllerGalleta();
           Galleta galleta = cg.obtenerDatosGalleta(id_gall);
            Gson gs = new Gson();
            out = gs.toJson(galleta);
        } catch (Exception ex){
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out="{\"error\":\""+ex.toString()+"\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
