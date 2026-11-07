/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package principal;

/**
 *
 * @author ARRIETB
 */

import java.io.FileWriter;
import java.io.PrintWriter;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.Factura;
import modelo.Producto;
import modelo.Usuario;
import util.BaseDatos;

public class Main {

    // Variable global para controlar el menú
    public static final String CANCELAR = "MENU FIDECOMPRO";

    // Solicita texto
    public static String pedirTexto(String mensaje) {

        while (true) {

            String dato =
                    JOptionPane.showInputDialog(
                            null,
                            mensaje);

            if (dato == null) {
                throw new RuntimeException(CANCELAR);
            }

            dato = dato.trim();

            if (!dato.isEmpty()) {
                return dato;
            }

            JOptionPane.showMessageDialog(
                    null,
                    "Valor incorrecto, ingrese nuevamente");
        }
    }

    // Solicita entero
    public static int pedirEntero(String mensaje) {

        while (true) {

            try {

                return Integer.parseInt(
                        pedirTexto(mensaje));

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Valor incorrecto, ingrese un número válido");
            }
        }
    }

    // Solicita decimal
    public static double pedirDecimal(String mensaje) {

        while (true) {

            try {

                return Double.parseDouble(
                        pedirTexto(mensaje));

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(
                        null,
                        "Valor incorrecto, ingrese un número válido");
            }
        }
    }

    public static void main(String[] args) {

        try {

            // Portada del sistema
            JOptionPane.showMessageDialog(
                    null,
                    "=====================================\n"
                    + "FIDECOMPRO\n"
                    + "=====================================\n\n"
                    + "Sistema de Facturación e Inventario\n\n"
                    + "Desarrollado por:\n"
                    + "Bernal Arrieta Soto\n"
                    + "Profesor:\n"  
                    + "Mario Alberto Vargas Montes\n"
                    + "Curso:\n"       
                    + "Programación Cliente/Servidor Concurrente\n"
                    + "Universidad Fidélitas\n"
                    + "III Cuatrimestre 2026\n\n"        
                    + "Ingrese usuario (admin) y contraseña (123) \n"
                    + "de administrador",
                    "Bienvenido",
                    JOptionPane.INFORMATION_MESSAGE);

            // Crear usuario administrador
            Usuario usuario =
                    new Usuario("admin", "123");

            String user =
                    pedirTexto("Digite usuario");

            String pass =
                    pedirTexto("Digite contraseña");

            if (!usuario.validarLogin(user, pass)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Usuario o contraseña incorrectos");

                System.exit(0);
            }

            int opcion = 0;

            do {

                try {

                    opcion =
                            pedirEntero(
                                    "MENU PRINCIPAL FIDECOMPRO\n\n"
                                    + "1. Registrar Cliente\n"
                                    + "2. Buscar Cliente\n"
                                    + "3. Modificar Cliente\n"
                                    + "4. Eliminar Cliente\n\n"
                                    + "5. Registrar Producto\n"
                                    + "6. Buscar Producto\n"
                                    + "7. Modificar Producto\n"
                                    + "8. Eliminar Producto\n\n"
                                    + "9. Generar Factura\n\n"
                                    + "10. Salir");

                    switch (opcion) {

                        case 1:
                            registrarCliente();
                            break;

                        case 2:
                            buscarCliente();
                            break;

                        case 3:
                            modificarCliente();
                            break;

                        case 4:
                            eliminarCliente();
                            break;

                        case 5:
                            registrarProducto();
                            break;

                        case 6:
                            buscarProducto();
                            break;

                        case 7:
                            modificarProducto();
                            break;

                        case 8:
                            eliminarProducto();
                            break;

                        case 9:
                            generarFactura();
                            break;

                        case 10:
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Gracias por utilizar Fidecompro");
                            break;

                        default:
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Opción inválida");
                    }

                } catch (RuntimeException e) {

                    if (CANCELAR.equals(e.getMessage())) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Operación cancelada");
                    }
                }

            } while (opcion != 10);

        } catch (RuntimeException e) {

            JOptionPane.showMessageDialog(
                    null,
                    "Programa finalizado");
        }
    }

    // Registrar cliente
    public static void registrarCliente() {

        String cedula =
                pedirTexto("Digite la cédula");

        for (Cliente c : BaseDatos.clientes) {

            if (c.getCedula().equals(cedula)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente ya existe");

                return;
            }
        }

        String nombre =
                pedirTexto("Digite el nombre");

        String telefono =
                pedirTexto("Digite el teléfono");

        Cliente cliente =
                new Cliente(
                        cedula,
                        nombre,
                        telefono);

        BaseDatos.clientes.add(cliente);

        JOptionPane.showMessageDialog(
                null,
                "Cliente registrado correctamente");
    }

    // Buscar cliente
    public static void buscarCliente() {

        String cedula =
                pedirTexto("Digite la cédula");

        for (Cliente c : BaseDatos.clientes) {

            if (c.getCedula().equals(cedula)) {

                JOptionPane.showMessageDialog(
                        null,
                        "Cédula: " + c.getCedula()
                        + "\nNombre: " + c.getNombre()
                        + "\nTeléfono: " + c.getTelefono());

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Cliente no encontrado");
    }

    // Modificar cliente
    public static void modificarCliente() {

        String cedula =
                pedirTexto("Digite la cédula");

        for (Cliente c : BaseDatos.clientes) {

            if (c.getCedula().equals(cedula)) {

                c.setNombre(
                        pedirTexto("Nuevo nombre"));

                c.setTelefono(
                        pedirTexto("Nuevo teléfono"));

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente actualizado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Cliente no encontrado");
    }

    // Eliminar cliente
    public static void eliminarCliente() {

        String cedula =
                pedirTexto("Digite la cédula");

        for (int i = 0; i < BaseDatos.clientes.size(); i++) {

            if (BaseDatos.clientes.get(i)
                    .getCedula()
                    .equals(cedula)) {

                BaseDatos.clientes.remove(i);

                JOptionPane.showMessageDialog(
                        null,
                        "Cliente eliminado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Cliente no encontrado");
    }

    // Registrar producto
    public static void registrarProducto() {

        int codigo =
                pedirEntero("Digite código");

        String nombre =
                pedirTexto("Digite nombre");

        double precio =
                pedirDecimal("Digite precio");

        int existencia =
                pedirEntero("Digite existencia");

        Producto producto =
                new Producto(
                        codigo,
                        nombre,
                        precio,
                        existencia);

        BaseDatos.productos.add(producto);

        JOptionPane.showMessageDialog(
                null,
                "Producto registrado");
    }

    // Buscar producto
    public static void buscarProducto() {

        int codigo =
                pedirEntero("Digite código");

        for (Producto p : BaseDatos.productos) {

            if (p.getCodigo() == codigo) {

                JOptionPane.showMessageDialog(
                        null,
                        "Código: " + p.getCodigo()
                        + "\nNombre: " + p.getNombre()
                        + "\nPrecio: ₡" + p.getPrecio()
                        + "\nExistencia: " + p.getExistencia());

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Producto no encontrado");
    }

    // Modificar producto
    public static void modificarProducto() {

        int codigo =
                pedirEntero("Digite código");

        for (Producto p : BaseDatos.productos) {

            if (p.getCodigo() == codigo) {

                p.setNombre(
                        pedirTexto("Nuevo nombre"));

                p.setPrecio(
                        pedirDecimal("Nuevo precio"));

                p.setExistencia(
                        pedirEntero("Nueva existencia"));

                JOptionPane.showMessageDialog(
                        null,
                        "Producto actualizado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Producto no encontrado");
    }

    // Eliminar producto
    public static void eliminarProducto() {

        int codigo =
                pedirEntero("Digite código");

        for (int i = 0; i < BaseDatos.productos.size(); i++) {

            if (BaseDatos.productos.get(i)
                    .getCodigo() == codigo) {

                BaseDatos.productos.remove(i);

                JOptionPane.showMessageDialog(
                        null,
                        "Producto eliminado");

                return;
            }
        }

        JOptionPane.showMessageDialog(
                null,
                "Producto no encontrado");
    }

    // Generar factura

    public static void generarFactura() {

        String cedula =
                pedirTexto(
                        "Cédula cliente");

        Cliente cliente = null;

        for(Cliente c :
                BaseDatos.clientes){

            if(c.getCedula().equals(
                    cedula)){

                cliente = c;
                break;
            }
        }

        if(cliente == null){

            JOptionPane.showMessageDialog(
                    null,
                    "Cliente no encontrado");

            return;
        }

        double subtotal = 0;

        String detalle = "";

        int continuar = 0;

        do{

            int codigo =
                    pedirEntero(
                            "Código producto");

            Producto producto = null;

            for(Producto p :
                    BaseDatos.productos){

                if(p.getCodigo() == codigo){

                    producto = p;
                    break;
                }
            }

            if(producto == null){

                JOptionPane.showMessageDialog(
                        null,
                        "Producto no encontrado");

                continue;
            }

            int cantidad =
                    pedirEntero(
                            "Cantidad");

            if(cantidad >
                    producto.getExistencia()){

                JOptionPane.showMessageDialog(
                        null,
                        "Inventario insuficiente");

                continue;
            }

            double linea =
                    producto.getPrecio()
                    * cantidad;

            subtotal += linea;

            producto.setExistencia(
                    producto.getExistencia()
                    - cantidad);

            detalle +=
                    producto.getNombre()
                    + " x "
                    + cantidad
                    + " = ₡"
                    + linea
                    + "\n";

            continuar =
                    JOptionPane.showConfirmDialog(

                            null,

                            "¿Agregar otro producto?",

                            "Factura FIDECOMPRO",

                            JOptionPane.YES_NO_OPTION);

        }while(continuar ==
                JOptionPane.YES_OPTION);

        Factura factura =
                new Factura(subtotal);

        String venta =

                "Cliente: "
                + cliente.getNombre()

                + "\n"

                + detalle

                + "\nTotal: ₡"
                + factura.getTotal();

        BaseDatos.ventas.add(
                venta);

        guardarFacturaTXT(
                cliente,
                detalle,
                factura);

        JOptionPane.showMessageDialog(

                null,

                "FACTURA FIDECOMPRO\n\n"

                + "Cliente: "
                + cliente.getNombre()

                + "\n\n"

                + detalle

                + "\nSubtotal: ₡"
                + factura.getSubtotal()

                + "\nIVA: ₡"
                + factura.getIva()

                + "\nTOTAL: ₡"
                + factura.getTotal());
    }
    
    // Generar archivo de factura

    public static void guardarFacturaTXT(

            Cliente cliente,
            String detalle,
            Factura factura) {

        try {

            FileWriter archivo =
                    new FileWriter(
                            "FacturaFIDECOMPRO.txt");

            PrintWriter escribir =
                    new PrintWriter(
                            archivo);

            escribir.println(
                    "FACTURA FIDECOMPRO");

            escribir.println();

            escribir.println(
                    "CLIENTE");

            escribir.println(
                    cliente.getNombre());

            escribir.println(
                    cliente.getCedula());

            escribir.println();

            escribir.println(
                    "PRODUCTOS");

            escribir.println(
                    detalle);

            escribir.println(
                    "Subtotal: ₡"
                    + factura.getSubtotal());

            escribir.println(
                    "IVA: ₡"
                    + factura.getIva());

            escribir.println(
                    "TOTAL: ₡"
                    + factura.getTotal());

           escribir.println(
                    "Gracias por su Compra"); 
            
            escribir.close();

        } catch(Exception e){

            JOptionPane.showMessageDialog(
                    null,
                    "Error generando factura");
        }
    }     
}