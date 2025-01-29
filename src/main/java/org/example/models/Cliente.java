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
