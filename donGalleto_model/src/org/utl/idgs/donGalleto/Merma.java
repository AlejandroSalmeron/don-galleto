/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.utl.idgs.donGalleto;

/**
 *
 * @author yahir
 */
public class Merma {
    private int id_merma;
    private String tipo_galleta;
    private double cantidad_inicial_gramos;
    private double cantidad_perdida_gramos;
    private String causa;

    public Merma() {
    }

    public Merma(String tipo_galleta, double cantidad_inicial_gramos, double cantidad_perdida_gramos, String causa) {
        this.tipo_galleta = tipo_galleta;
        this.cantidad_inicial_gramos = cantidad_inicial_gramos;
        this.cantidad_perdida_gramos = cantidad_perdida_gramos;
        this.causa = causa;
    }

    public Merma(int id_merma, String tipo_galleta, double cantidad_inicial_gramos, double cantidad_perdida_gramos, String causa) {
        this.id_merma = id_merma;
        this.tipo_galleta = tipo_galleta;
        this.cantidad_inicial_gramos = cantidad_inicial_gramos;
        this.cantidad_perdida_gramos = cantidad_perdida_gramos;
        this.causa = causa;
    }

    public String getCausa() {
        return causa;
    }

    public void setCausa(String causa) {
        this.causa = causa;
    }

    public int getId_merma() {
        return id_merma;
    }

    public void setId_merma(int id_merma) {
        this.id_merma = id_merma;
    }

    public String getTipo_galleta() {
        return tipo_galleta;
    }

    public void setTipo_galleta(String tipo_galleta) {
        this.tipo_galleta = tipo_galleta;
    }

    public double getCantidad_inicial_gramos() {
        return cantidad_inicial_gramos;
    }

    public void setCantidad_inicial_gramos(double cantidad_inicial_gramos) {
        this.cantidad_inicial_gramos = cantidad_inicial_gramos;
    }

    public double getCantidad_perdida_gramos() {
        return cantidad_perdida_gramos;
    }

    public void setCantidad_perdida_gramos(double cantidad_perdida_gramos) {
        this.cantidad_perdida_gramos = cantidad_perdida_gramos;
    }

    @Override
    public String toString() {
        return "merma{" + "id_merma=" + id_merma + ", tipo_galleta=" + tipo_galleta + ", cantidad_inicial_gramos=" + cantidad_inicial_gramos + ", cantidad_perdida_gramos=" + cantidad_perdida_gramos + ", causa=" + causa + '}';
    }
    
}
