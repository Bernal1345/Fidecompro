/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

/**
 *
 * @author ARRIETB
 */

import java.util.ArrayList;
import modelo.Cliente;
import modelo.Producto;

// Colecciones
public class BaseDatos {

    public static ArrayList<Cliente> clientes =
            new ArrayList<>();

    public static ArrayList<Producto> productos =
            new ArrayList<>();
    // Historial de ventas
    public static ArrayList<String> ventas =
            new ArrayList<>();
}