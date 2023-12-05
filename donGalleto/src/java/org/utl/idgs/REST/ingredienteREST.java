/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.REST;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.sun.research.ws.wadl.Application;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;
import org.utl.idgs.cuidador.controller.ControllerIngrediente;
import org.utl.idgs.donGalleto.Ingrediente;

/**
 *
 * @author yahir
 */
@Path("ingrediente")
public class ingredienteREST extends Application{

    @Path("insertarIngrediente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertarIngrediente(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        String out = "";

        Ingrediente ingrediente = new Ingrediente();
        ingrediente = gson.fromJson(datos, Ingrediente.class);
        ControllerIngrediente ci = new ControllerIngrediente();

        try {
            ci.insertarIngrediente(ingrediente);
            out = gson.toJson(ingrediente);
        } catch (JsonParseException json) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }

        return Response.status(Response.Status.OK).entity(out).build();

    }

    @Path("actualizarIngrediente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response actualizarIngrediente(@FormParam("datos") @DefaultValue("") String datos) {
        Gson gson = new Gson();
        Ingrediente ingrediente = new Ingrediente();
        //El punto class es la especificacion que contiene la clase
        ingrediente = gson.fromJson(datos, Ingrediente.class);
        String out = "";
        ControllerIngrediente ci = new ControllerIngrediente();
        try {
            ci.actualizarIngrediente(ingrediente);
            out = gson.toJson(ingrediente);
        } catch (JsonParseException jpe) {
            out = """
                   {"error": "Error de formato"}
                   """;
        } catch (SQLException ex) {

            out = "{\"error\":\"" + ex.toString() + "\"}";

        }

        return Response.status(Response.Status.OK).entity(out).build();
    }

    @Path("getIngrediente")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response getIngrediente(@FormParam("id") @DefaultValue("") String id) {
        String out = "";
        int id_ing = Integer.parseInt(id);
        try {
            ControllerIngrediente ci = new ControllerIngrediente();
            Ingrediente ingrediente = ci.obtenerDatosIngrediente(id_ing);
            Gson gs = new Gson();
            out = gs.toJson(ingrediente);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
    @Path("getAllIngredientes")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllIngredientes() {
        String out = "";
        try {
            ControllerIngrediente ci = new ControllerIngrediente();
            List<Ingrediente> ingredientes = ci.getAllIngredientes();
            Gson gs = new Gson();
            out = gs.toJson(ingredientes);
        } catch (Exception ex) {
            System.out.println(ex.toString());
            //Poner diagonal inversa Alt+92
            out = "{\"error\":\"" + ex.toString() + "\"}";
        }
        return Response.status(Response.Status.OK).entity(out).build();
    }
    
}
