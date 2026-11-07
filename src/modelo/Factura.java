/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ARRIETB
 */
public class Factura {

    private double subtotal;
    private double iva;
    private double total;

    public Factura(double subtotal) {

        this.subtotal = subtotal;

        iva = subtotal * 0.13;

        total = subtotal + iva;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getIva() {
        return iva;
    }

    public double getTotal() {
        return total;
    }
}