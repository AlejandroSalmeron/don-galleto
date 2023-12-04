/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.donGalleto;

/**
 *
 * @author yahir
 */
public class Galleta {
    private int id_galleta;
    private String nombre_galleta;
    private int cantidad_producida;
    private double precio_galleta;
    private String comentario;

    public Galleta() {
    }

    public Galleta(String nombre_galleta, int cantidad_producida, double precio_galleta, String comentario) {
        this.nombre_galleta = nombre_galleta;
        this.cantidad_producida = cantidad_producida;
        this.precio_galleta = precio_galleta;
        this.comentario = comentario;
    }
    
    public Galleta(int id_galleta, String nombre_galleta, int cantidad_producida, double precio_galleta, String comentario) {
        this.id_galleta = id_galleta;
        this.nombre_galleta = nombre_galleta;
        this.cantidad_producida = cantidad_producida;
        this.precio_galleta = precio_galleta;
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getId_galleta() {
        return id_galleta;
    }

    public void setId_galleta(int id_galleta) {
        this.id_galleta = id_galleta;
    }

    public String getNombre_galleta() {
        return nombre_galleta;
    }

    public void setNombre_galleta(String nombre_galleta) {
        this.nombre_galleta = nombre_galleta;
    }

    public int getCantidad_producida() {
        return cantidad_producida;
    }

    public void setCantidad_producida(int cantidad_producida) {
        this.cantidad_producida = cantidad_producida;
    }

    public double getPrecio_galleta() {
        return precio_galleta;
    }

    public void setPrecio_galleta(double precio_galleta) {
        this.precio_galleta = precio_galleta;
    }

    @Override
    public String toString() {
        return "galleta{" + "id_galleta=" + id_galleta + ", nombre_galleta=" + nombre_galleta + ", cantidad_producida=" + cantidad_producida + ", precio_galleta=" + precio_galleta + ", comentario=" + comentario + '}';
    }   
    
}
