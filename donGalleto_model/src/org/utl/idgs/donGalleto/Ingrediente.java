/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.donGalleto;

/**
 *
 * @author yahir
 */
public class Ingrediente {
    private int id_ingrediente;
    private String nombre_ingrediente;
    private double cantidad;
    private String unidad_medida;

    public Ingrediente() {
    }

    public Ingrediente(String nombre_ingrediente, double cantidad, String unidad_medida) {
        this.nombre_ingrediente = nombre_ingrediente;
        this.cantidad = cantidad;
        this.unidad_medida = unidad_medida;
    }

    public Ingrediente(int id_ingrediente, String nombre_ingrediente, double cantidad, String unidad_medida) {
        this.id_ingrediente = id_ingrediente;
        this.nombre_ingrediente = nombre_ingrediente;
        this.cantidad = cantidad;
        this.unidad_medida = unidad_medida;
    }

    public String getUnidad_medida() {
        return unidad_medida;
    }

    public void setUnidad_medida(String unidad_medida) {
        this.unidad_medida = unidad_medida;
    }

    public int getId_ingrediente() {
        return id_ingrediente;
    }

    public void setId_ingrediente(int id_ingrediente) {
        this.id_ingrediente = id_ingrediente;
    }

    public String getNombre_ingrediente() {
        return nombre_ingrediente;
    }

    public void setNombre_ingrediente(String nombre_ingrediente) {
        this.nombre_ingrediente = nombre_ingrediente;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ingrediente{" + "id_ingrediente=" + id_ingrediente + ", nombre_ingrediente=" + nombre_ingrediente + ", cantidad=" + cantidad + ", unidad_medida=" + unidad_medida + '}';
    }
    
    
}
