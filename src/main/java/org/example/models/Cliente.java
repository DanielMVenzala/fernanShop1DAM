package org.example.models;

import java.util.Scanner;

import static org.example.utils.Utils.limpiaPantalla;
import static org.example.utils.Utils.pulsaParaContinuar;
import static org.example.view.Main.enviaTokenMailCliente;

public class Cliente {
    Scanner sc = new Scanner(System.in);

    // Atributos
    private String nombre;
    private String apellidos;
    private String direccion;
    private String localidad;
    private String provincia;
    private int telefono;
    private String correo;
    private String clave;
    private Pedido pedido1;
    private Pedido pedido2;

    // Constructores
    public Cliente(String nombre, String apellidos, String direccion, String localidad, String provincia, int telefono, String correo, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.localidad = localidad;
        this.provincia = provincia;
        this.telefono = telefono;
        this.correo = correo;
        this.clave = clave;
        pedido1 = null;
        pedido2 = null;
    }

    // Los constructores vacíos los he inicializado con los campos vacíos para no tener problemas con los null
    public Cliente() {
    }

    public Cliente(Cliente cliente) {
        nombre = cliente.nombre;
        apellidos = cliente.apellidos;
        direccion = cliente.direccion;
        localidad = cliente.localidad;
        provincia = cliente.provincia;
        telefono = cliente.telefono;
        correo = cliente.correo;
        clave = cliente.clave;
        pedido1 = cliente.pedido1;
        pedido2 = cliente.pedido2;
    }

    // Método para pintar los datos de un cliente
    public String pintaCliente() {
        String resultado = "";
        resultado += "DATOS PERSONALES\n==================\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Apellidos: " + apellidos + "\n";
        resultado += "Dirección: " + direccion + "\n";
        resultado += "Localidad: " + localidad + "\n";
        resultado += "Provincia: " + provincia + "\n";
        resultado += "Teléfono: " + telefono + "\n";
        resultado += "Correo electrónico: " + correo + "\n";
        resultado += "Contraseña: " + clave + "\n";
        resultado += "===============================================\n";

        return resultado;
    }

    // Método para pintar todos los pedidos que se han realizado
    public String pintaPedidosCliente() {
        String resultado = "";
        if (pedido1 == null && pedido2 == null) {
            resultado += "No has realizado ningún pedido.";
        }
        resultado += (pedido1 == null) ? "" : pedido1.pintaPedido();
        resultado += "\n";
        resultado += (pedido2 == null) ? "" : pedido2.pintaPedido();
        return resultado;
    }

    // Método para modificar alguno de los atributos del cliente, con un switch
    public void modificaDatosCliente(Scanner sc) throws NumberFormatException {
        int op = 0;
        do {
            System.out.print("""
                            ¿Qué dato quieres cambiar?
                            1. Nombre
                            2. Apellidos
                            3. Dirección
                            4. Localidad
                            5. Provincia
                            6. Teléfono
                            7. Correo electrónico
                            8. Clave
                            9. Volver
                            Introduce una opción: 
                            """);

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduzca una opción correcta.");
            }

            switch (op) {
                case 1:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevoNombre = sc.nextLine();
                    nombre = nuevoNombre;
                    System.out.println("Nombre cambiado correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;

                case 2:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevoApellido = sc.nextLine();
                    apellidos = nuevoApellido;
                    System.out.println("Apellidos cambiados correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaDireccion = sc.nextLine();
                    direccion = nuevaDireccion;
                    System.out.println("Dirección cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 4:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaLocalidad = sc.nextLine();
                    localidad = nuevaLocalidad;
                    System.out.println("Localidad cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 5:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaProvincia = sc.nextLine();
                    provincia = nuevaProvincia;
                    System.out.println("Provincia cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 6:
                    System.out.print("Introduce el nuevo valor: ");
                    int nuevoTelefono = Integer.parseInt(sc.nextLine());
                    telefono = nuevoTelefono;
                    System.out.println("Teléfono cambiado correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 7:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevoCorreo = sc.nextLine();
                    correo = nuevoCorreo;
                    int token = generaToken();
                    int tokenUsuario;
                    System.out.println("Un momento por favor...");
                    enviaTokenMailCliente(token, nuevoCorreo, nombre);
                    do {
                        System.out.println("Introduce el token que has recibido al nuevo mail para continuar:");
                        tokenUsuario = Integer.parseInt(sc.nextLine());

                        if (tokenUsuario != token) System.out.println("Token incorrecto.");
                    } while (tokenUsuario != token);

                    System.out.println("Correo cambiado correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 8:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaClave = sc.nextLine();
                    clave = nuevaClave;
                    System.out.println("Clave cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Opción incorrecta...");
            }
        } while (op != 9);
        System.out.println();
    }

    public int generaToken() {
        return (int) (Math.random() * 999999);
    }

    // Getters y setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Pedido getPedido1() {
        return pedido1;
    }

    public void setPedido1(Pedido pedido1) {
        this.pedido1 = pedido1;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }
}
