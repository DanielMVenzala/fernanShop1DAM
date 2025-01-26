package org.example.models;

import java.time.LocalDate;

public class Pedido {

    // Atributos
    private String idPedido;
    private String estado;
    private Cliente cliente;
    private Producto producto1;
    private Producto producto2;
    private Producto producto3;
    private LocalDate fechaPedido;
    private LocalDate fechaEntrega;
    private String comentario;
    private float totalPedido;
    private static int contadorID = 1;
    private int contadorPedidos = 0;

    // El id pedido se autoincrementa con la creación de un nuevo pedido
    public Pedido(Cliente cliente, Producto producto1){

        idPedido = String.valueOf((int) (Math.random() * 100000));
        estado = "Recibido";
        this.cliente = cliente;
        this.producto1 = producto1;
        this.producto2 = null;
        this.producto3 = null;
        fechaPedido = LocalDate.now();
        fechaEntrega = LocalDate.now().plusDays(5);
        comentario = "";
        totalPedido = ((producto1 == null) ? 0 : producto1.getPrecio()) +
                ((producto2 == null) ? 0 : producto2.getPrecio()) +
                ((producto3 == null) ? 0 : producto3.getPrecio());
        contadorID ++;
        contadorPedidos ++;
    }

    public Pedido() {

    }

    public Pedido (Pedido pedido) {
        idPedido = pedido.idPedido;
        estado = pedido.estado;
        cliente = pedido.cliente;
        producto1 = pedido.producto1;
        producto2 = pedido.producto2;
        producto3 = pedido.producto3;
        fechaPedido = pedido.fechaPedido;
        comentario = pedido.comentario;
        totalPedido = pedido.totalPedido;
        contadorPedidos = pedido.contadorPedidos;
    }

    // Método para calcular el número de productos de cada pedido
    // Servirá para mostrarlo en el menú de administrador y saber cuántos productos hay dentro de cada pedido
    public int cuentaProductos() {
        int contadorProductos = 0;
        if (producto1 != null && producto2 == null && producto3 == null) contadorProductos = 1;
        if (producto1 != null && producto2 != null && producto3 == null) contadorProductos = 2;
        if (producto1 != null && producto2 != null && producto3 != null) contadorProductos = 3;

        return contadorProductos;
    }

    // Método que pinta toda la info de un pedido
    public String pintaPedido() {
        float totalPedido = ((producto1 == null) ? 0 : producto1.getPrecio()) +
                ((producto2 == null) ? 0 : producto2.getPrecio()) + ((producto3 == null) ? 0 : producto3.getPrecio());
        String resultado = "";
        resultado += "=========== Pedido " + idPedido + " ===========\n";
        resultado += "Estado: " + estado + "\n";
        resultado += "Cliente: " + cliente.getNombre() + " " + cliente.getApellidos() + "\n";
        resultado += "Dirección: " + cliente.getDireccion() + "\n";
        resultado += "Localidad: " + cliente.getLocalidad() + "\n";
        resultado += "Provincia: " + cliente.getProvincia() + "\n";
        resultado += "Teléfono: " + cliente.getTelefono() + "\n";
        resultado += "Correo: " + cliente.getCorreo() + "\n";
        resultado += "Fecha del pedido: " + fechaPedido + "\n";
        resultado += "Fecha de entrega estimada: " + fechaEntrega + "\n";
        resultado += "Comentario del pedido: " + comentario + "\n";
        resultado += "Detalles del pedido:\n";
        resultado += "\t" + ((producto1 == null) ? "" : producto1.pintaProducto()) + "\n";
        resultado += "\t" + ((producto2 == null) ? "" : producto2.pintaProducto()) + "\n";
        resultado += "\t" + ((producto3 == null) ? "" : producto3.pintaProducto()) + "\n";
        resultado += "Total pedido: " + totalPedido + "€\n";
        resultado += "====================================================\n";

        return resultado;
    }

    // Getters y setters

    // El método getTotalPedido se ha adaptado para que no haya errores con los pedidos que sean null
    public float getTotalPedido() {
        return ((producto1 == null) ? 0 : producto1.getPrecio()) +
                ((producto2 == null) ? 0 : producto2.getPrecio()) +
                ((producto3 == null) ? 0 : producto3.getPrecio());
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Producto getProducto2() {
        return producto2;
    }

    public void setProducto2(Producto producto2) {
        this.producto2 = producto2;
    }

    public Producto getProducto3() {
        return producto3;
    }

    public void setProducto3(Producto producto3) {
        this.producto3 = producto3;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setTotalPedido(float totalPedido) {
        this.totalPedido = totalPedido;
    }

    public int getContadorPedidos() {
        return contadorPedidos;
    }

    public void setContadorPedidos(int contadorPedidos) {
        this.contadorPedidos = contadorPedidos;
    }
}
