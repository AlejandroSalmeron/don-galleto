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
    private Galleta id_galleta;
    private double cantidad;
    private String unidad_medida;
    private double precio;
    private double total;

    public Venta() {
    }

    public Venta(Galleta id_galleta, double cantidad, String unidad_medida, double precio, double total) {
        this.id_galleta = id_galleta;
        this.cantidad = cantidad;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
        this.total = total;
    }

    
    public Venta(int id_venta, Galleta id_galleta, double cantidad, String unidad_medida, double precio, double total) {
        this.id_venta = id_venta;
        this.id_galleta = id_galleta;
        this.cantidad = cantidad;
        this.unidad_medida = unidad_medida;
        this.precio = precio;
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

    public Galleta getId_galleta() {
        return id_galleta;
    }

    public void setId_galleta(Galleta id_galleta) {
        this.id_galleta = id_galleta;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "venta{" + "id_venta=" + id_venta + ", id_galleta=" + id_galleta + ", cantidad=" + cantidad + ", unidad_medida=" + unidad_medida + ", precio=" + precio + ", total=" + total + '}';
    }
    
}
