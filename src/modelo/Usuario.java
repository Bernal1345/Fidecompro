/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ARRIETB
 */

public class Usuario {

    private String usuario;
    private String clave;

    public Usuario(String usuario,
                   String clave) {

        this.usuario = usuario;
        this.clave = clave;
    }

    public boolean validarLogin(
            String usuario,
            String clave) {

        return this.usuario.equals(usuario)
                && this.clave.equals(clave);
    }
}
