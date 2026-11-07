/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ARRIETB
 */

// Clase padre
public class Persona {

    protected String nombre;
    protected String telefono;

    // Constructor
    public Persona(String nombre, String telefono) {

        this.nombre = nombre;
        this.telefono = telefono;
    }

    // Metodo que se sobrescribira
    public void mostrarDatos() {

        System.out.println(nombre);
    }
}