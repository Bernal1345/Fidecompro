/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ARRIETB
 */

// Herencia
public class Cliente extends Persona {

    private String cedula;

    public Cliente(String cedula,
                   String nombre,
                   String telefono) {

        super(nombre, telefono);

        this.cedula = cedula;
    }

    // Polimorfismo
    @Override
    public void mostrarDatos() {

        System.out.println(
                cedula + " "
                + nombre + " "
                + telefono);
    }

    public String getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}