/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.donGalleto;

/**
 *
 * @author yahir
 */
public class Venta {
    private int id_venta;
    
    private String comentario;
   
    private double total;

    public Venta() {
    }

    public Venta(int id_venta, String comentario, double total) {
        this.id_venta = id_venta;
        this.comentario = comentario;
        this.total = total;
    }

    public Venta(String comentario, double total) {
        this.comentario = comentario;
        this.total = total;
    }

    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Venta{" + "id_venta=" + id_venta + ", comentario=" + comentario + ", total=" + total + '}';
    }
    

   
    
}
