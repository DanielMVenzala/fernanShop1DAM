package org.example.models;

import java.util.Scanner;

public class Trabajador {
    // Atributos
    private String nombre;
    private String apellidos;
    private String correo;
    private String clave;
    private Pedido pedido1;
    private Pedido pedido2;
    private int contadorPedidos;

    // Constructores
    public Trabajador(){
    }

    public Trabajador(String nombre, String apellidos, String mail, String clave) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = mail;
        this.clave = clave;
        pedido1 = null;
        pedido2 = null;
        contadorPedidos = 0;
    }

    public Trabajador(Trabajador trabajador) {
        nombre = trabajador.nombre;
        apellidos = trabajador.apellidos;
        correo = trabajador.correo;
        clave = trabajador.clave;
        pedido1 = trabajador.pedido1;
        pedido2 = trabajador.pedido2;
        contadorPedidos = trabajador.contadorPedidos;
    }

    // Método que cuenta los pedidos para luego mostrar el contador en el menú
    public int cuentaPedidos() {
        int contadorPedidos = 0;
        if (pedido1 != null) contadorPedidos ++;
        if (pedido2 != null) contadorPedidos ++;
        return contadorPedidos;
    }

    // Método que pinta el perfil del trabajador
    public String pintaTrabajador() {
        String resultado = "";
        resultado += "====== PERFIL DE TRABAJADOR ======\n";
        resultado += "Nombre: " + nombre + "\n";
        resultado += "Apellidos: " + apellidos + "\n";
        resultado += "Correo electrónico: " + correo + "\n";
        resultado += "Clave: " + clave + "\n";
        resultado += "Pedidos:\n";
        resultado += "\t" + ((pedido1 != null) ? pedido1.pintaPedido() : "Pedido vacío\n");
        resultado += "\t" + ((pedido2 != null) ? pedido2.pintaPedido() : "Pedido vacío\n");
        resultado += "===========================================\n";

        return resultado;
    }

    // Método que se llama en el menú del trabajador para que muestre los pedidos que tiene asginados él personalmente
    public String consultaPedidos() {
        String resultado = "";
        if (pedido1 != null) resultado += pedido1.pintaPedido();
        if (pedido2 != null) resultado += pedido2.pintaPedido();
        if (pedido1 == null && pedido2 == null) resultado += "No hay pedidos asignados";

        return resultado;
    }

    // Método para modificar los atributos o datos del trabajador
    public void modificaDatosTrabajador(Scanner sc) {
        int op;
        System.out.print("""
                            ¿Qué dato quieres modificar de tu perfil?
                            1. Nombre
                            2. Apellidos
                            3. Correo electrónico
                            4. Contraseña
                            5. Volver
                            Selecciona una opción: 
                            """);
        op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1:
                System.out.print("Introduce el nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                nombre = nuevoNombre;
                System.out.println("Nombre actualizado correctamente.");
                break;
            case 2:
                System.out.print("Introduce los nuevos apellidos: ");
                String nuevosApellidos = sc.nextLine();
                apellidos = nuevosApellidos;
                System.out.println("Apellidos actualizados correctamente.");
                break;
            case 3:
                System.out.print("Introduce el nuevo correo: ");
                String nuevoCorreo = sc.nextLine();
                correo = nuevoCorreo;
                System.out.println("Correo actualizado correctamente.");
                break;
            case 4:
                System.out.print("Introduce la nueva clave: ");
                String nuevaClave = sc.nextLine();
                clave = nuevaClave;
                System.out.println("Clave actualizada correctamente.");
                break;
            case 5:
                break;
            default:
                System.out.println("Opción incorrecta.");
        }

    }

    // Getters y setters


    public int getContadorPedidos() {
        return contadorPedidos;
    }

    public void setContadorPedidos(int contadorPedidos) {
        this.contadorPedidos = contadorPedidos;
    }

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
        contadorPedidos ++;
    }

    public Pedido getPedido2() {
        return pedido2;
    }

    public void setPedido2(Pedido pedido2) {
        this.pedido2 = pedido2;
    }
}
