package org.example.models;

import java.time.LocalDate;
import java.util.Scanner;

import static org.example.view.Main.mailModificaPedidoTrabajador;
import static org.example.view.Main.mandaMailTrabajador;

// En los atributos de la clase Admin añadimos a los dos clientes y a los tres trabajadores que gestionará
public class Admin {
    private String usuario;
    private String clave;
    private Cliente cliente1;
    private Cliente cliente2;
    private Trabajador trabajador1;
    private Trabajador trabajador2;
    private Trabajador trabajador3;
    private int contadorPedidos;

    public Admin(String usuario, String clave, Cliente cliente1, Cliente cliente2, Trabajador trabajador1,
                 Trabajador trabajador2, Trabajador trabajador3) {
        this.usuario = usuario;
        this.clave = clave;
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.trabajador1 = trabajador1;
        this.trabajador2 = trabajador2;
        this.trabajador3 = trabajador3;
        contadorPedidos = 0;
    }

    public Admin() {
    }

    // Getters y setters
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Cliente getCliente1() {
        return cliente1;
    }

    public void setCliente1(Cliente cliente1) {
        this.cliente1 = cliente1;
    }

    public Cliente getCliente2() {
        return cliente2;
    }

    public void setCliente2(Cliente cliente2) {
        this.cliente2 = cliente2;
    }

    public Trabajador getTrabajador1() {
        return trabajador1;
    }

    public void setTrabajador1(Trabajador trabajador1) {
        this.trabajador1 = trabajador1;
    }

    public Trabajador getTrabajador2() {
        return trabajador2;
    }

    public void setTrabajador2(Trabajador trabajador2) {
        this.trabajador2 = trabajador2;
    }

    public Trabajador getTrabajador3() {
        return trabajador3;
    }

    public void setTrabajador3(Trabajador trabajador3) {
        this.trabajador3 = trabajador3;
    }

    public int getContadorPedidos() {
        return contadorPedidos;
    }

    public void setContadorPedidos(int contadorPedidos) {
        this.contadorPedidos = contadorPedidos;
    }



    // Método que nos pinta los pedidos que hay sin asignar (en caso de empate), antes de asignárselos a un trabajador en concreto
    public String pintaPedidosAdmin() {
        String resultado = "";
        int contadorMenu = 1;

        if (trabajador1.cuentaPedidos() == 1 && trabajador2.cuentaPedidos() == 1 && trabajador3.cuentaPedidos() == 1) {
            if (cliente1.getPedido1() != null && cliente1.getPedido1().getEstado().equalsIgnoreCase("recibido")) {
                resultado += contadorMenu + ". " + cliente1.getPedido1().getIdPedido() + " - " + cliente1.getNombre() + " " +
                        cliente1.getApellidos() + " (" + cliente1.getProvincia() + ") - " +
                        cliente1.getPedido1().cuentaProductos() + " productos - " + cliente1.getPedido1().getTotalPedido() + "€\n";
                contadorMenu ++;
            } else resultado += "";

            if (cliente1.getPedido2() != null && cliente1.getPedido2().getEstado().equalsIgnoreCase("recibido")) {
                resultado += contadorMenu + ". " + cliente1.getPedido2().getIdPedido() + " - " + cliente1.getNombre() + " " +
                        cliente1.getApellidos() + " (" + cliente1.getProvincia() + ") - " +
                        cliente1.getPedido2().cuentaProductos() + " productos - " + cliente1.getPedido2().getTotalPedido() + "€\n";
                contadorMenu ++;
            } else resultado += "";

            if (cliente2.getPedido1() != null && cliente2.getPedido1().getEstado().equalsIgnoreCase("recibido")) {
                resultado += contadorMenu + ". " + cliente2.getPedido1().getIdPedido() + " - " + cliente2.getNombre() + " " +
                        cliente2.getApellidos() + " (" + cliente2.getProvincia() + ") - " +
                        cliente2.getPedido1().cuentaProductos() + " productos - " + cliente2.getPedido1().getTotalPedido() + "€\n";
                contadorMenu ++;
            } else resultado += "";

            if (cliente2.getPedido2() != null && cliente2.getPedido2().getEstado().equalsIgnoreCase("recibido")) {
                resultado += contadorMenu + ". " + cliente2.getPedido2().getIdPedido() + " - " + cliente2.getNombre() + " " +
                        cliente2.getApellidos() + " (" + cliente2.getProvincia() + ") - " +
                        cliente2.getPedido2().cuentaProductos() + " productos - " + cliente2.getPedido2().getTotalPedido() + "€\n";
            } else resultado += "";
        }
        return resultado;
    }






    // Método que se llama cuando somos administradores y queremos asignar un pedido a un trabajador
    public void asignaPedidoAdmin(Scanner sc) {
        Pedido pedido = null;

        if (cliente1.getPedido1() == null && cliente1.getPedido2() == null && cliente2.getPedido1() == null && cliente2.getPedido2() == null) {
            System.out.println("No hay pedidos por asignar en este momento.");
            return;
        }

        System.out.println("==== Asignación de trabajadores a pedidos ====");
        System.out.println(pintaPedidosAdmin());
        System.out.print("Seleccione el ID del pedido que quieres asignar: ");
        String id = sc.nextLine();

        if (cliente1.getPedido1() != null && id.equals(cliente1.getPedido1().getIdPedido())) {
            pedido = cliente1.getPedido1();
        } else if (cliente1.getPedido2() != null && id.equals(cliente1.getPedido2().getIdPedido())) {
            pedido = cliente1.getPedido2();
        } else if (cliente2.getPedido1() != null && id.equals(cliente2.getPedido1().getIdPedido())) {
            pedido = cliente2.getPedido1();
        } else if (cliente2.getPedido2() != null && id.equals(cliente2.getPedido2().getIdPedido())) {
            pedido = cliente2.getPedido2();
        }

        if (pedido == null) {
            System.out.println("ID del pedido no encontrado.");
            return;
        }

        System.out.println(pintaPedidosAsignadosTrabajador(trabajador1, trabajador2, trabajador3));
        System.out.print("Seleccione el trabajador al que quieres asignar el pedido: ");
        int op = Integer.parseInt(sc.nextLine());
        Trabajador trabajadorAsignado = null;

        switch (op) {
            case 1:
                trabajadorAsignado = trabajador1;
                break;
            case 2:
                trabajadorAsignado = trabajador2;
                break;
            case 3:
                trabajadorAsignado = trabajador3;
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

        if (trabajadorAsignado.getPedido1() == null) {
            trabajadorAsignado.setPedido1(pedido);
        } else if (trabajadorAsignado.getPedido2() == null) {
            trabajadorAsignado.setPedido2(pedido);
        } else {
            System.out.println("El trabajador seleccionado ya tiene 2 pedidos asignados.");
            return;
        }

        pedido.setEstado("En preparación");
        System.out.println("Pedido asignado correctamente a " + trabajadorAsignado.getNombre());
    }


    // Método que nos muestra los pedidos que tiene asignado cada trabajador
    public String pintaPedidosAsignadosTrabajador(Trabajador trabajador1, Trabajador trabajador2, Trabajador trabajador3) {
        String resultado = "";
        int contadorMenu = 1;

        resultado += contadorMenu + ". " + trabajador1.getNombre() + " - " + trabajador1.cuentaPedidos() + " pedido/s en proceso.\n";
        contadorMenu++;

        resultado += contadorMenu + ". " + trabajador2.getNombre() + " - " + trabajador2.cuentaPedidos() + " pedido/s en proceso.\n";
        contadorMenu ++;

        resultado += contadorMenu + ". " + trabajador3.getNombre() + " - " + trabajador3.cuentaPedidos() + " pedido/s en proceso.\n";

        return resultado;
    }




    public void modificaEstadoPedidoTrabajador(Scanner sc, Trabajador trabajador) {
        if (trabajador.cuentaPedidos() == 0) {
            System.out.println("No hay pedidos asignados para modificar.");
        } else {
            System.out.println("Pedidos asignados:");
            System.out.println(trabajador.consultaPedidos());

            System.out.println("Introduce el ID del pedido a modificar: ");
            String idPedido = sc.nextLine();
            Pedido pedido;

            if (trabajador.getPedido1() != null && idPedido.equals(trabajador.getPedido1().getIdPedido())) {
                pedido = trabajador.getPedido1();
            } else if (trabajador.getPedido2() != null && idPedido.equals(trabajador.getPedido2().getIdPedido())) {
                pedido = trabajador.getPedido2();
            } else {
                System.out.println("ID del pedido no encontrado.");
                return;
            }
            modificaEstado(pedido);
            mailModificaPedidoTrabajador(pedido, trabajador, trabajador.getCorreo());
        }
    }


    public void menuModificaEstadoAdmin(Scanner sc) {

        // TODO da error cuando utilizo este método
        if (cliente1.getPedido1() != null) System.out.println(cliente1.getPedido1().pintaPedido());
        if (cliente1.getPedido2() != null) System.out.println(cliente1.getPedido2().pintaPedido());
        if (cliente2.getPedido1() != null) System.out.println(cliente2.getPedido1().pintaPedido());
        if (cliente2.getPedido2() != null) System.out.println(cliente2.getPedido2().pintaPedido());

        System.out.println("¿A qué pedido quieres modificar al estado? (introduce el ID) ");
        String idPedido = sc.nextLine();
        Pedido pedido;
        if (cliente1.getPedido1() != null && idPedido.equals(cliente1.getPedido1().getIdPedido())) {
            pedido = cliente1.getPedido1();
            modificaEstado(pedido);
        }
        if (cliente1.getPedido2() != null && idPedido.equals(cliente1.getPedido2().getIdPedido())) {
            pedido = cliente1.getPedido2();
            modificaEstado(pedido);
        }
        if (cliente2.getPedido1() != null && idPedido.equals(cliente2.getPedido1().getIdPedido())) {
            pedido = cliente2.getPedido1();
            modificaEstado(pedido);
        }
        if (cliente2.getPedido2() != null && idPedido.equals(cliente2.getPedido2().getIdPedido())) {
            pedido = cliente2.getPedido2();
            modificaEstado(pedido);
        }
    }

    // Método que modifica el estado de un pedido en concreto
    public void modificaEstado(Pedido pedido) {
        Scanner sc = new Scanner(System.in);
        int op;
        boolean salir = false;

        do {
            System.out.println("==== Actualización del pedido " + pedido.getIdPedido() + " ====");
            System.out.println("Estado del pedido: " + pedido.getEstado());
            System.out.println("""
                            Nuevo estado:
                            1. Recibido
                            2. En preparación
                            3. Retrasado
                            4. Cancelado
                            5. Enviado
                            6. Volver
                            Selecciona el nuevo estado: 
                            """);
            op = Integer.parseInt(sc.nextLine());
            switch (op) {
                case 1:
                    pedido.setEstado("Recibido");
                    break;
                case 2:
                    pedido.setEstado("En preparación");
                    break;
                case 3:
                    pedido.setEstado("Retrasado");
                    break;
                case 4:
                    pedido.setEstado("Cancelado");
                    break;
                case 5:
                    pedido.setEstado("Enviado");
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (op != 6);
        System.out.println("Estado actualizado correctamente.");

        System.out.print("¿Quiere indicar una nueva fecha de entrega? (si/no): ");
        String respuesta = sc.nextLine();

        if (respuesta.equalsIgnoreCase("si")) {
            System.out.print("Introduce la nueva fecha. Ejemplo (2024-12-31): ");
            LocalDate nuevaFecha = LocalDate.parse(sc.nextLine());
            pedido.setFechaEntrega(nuevaFecha);

            System.out.print("¿Quiere añadir un comentario al pedido? (si/no): ");
            respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("si")) {
                System.out.print("Introduce un comentario: ");
                String nuevoComentario = sc.nextLine();
                pedido.setComentario(nuevoComentario);
            }
        }
        System.out.println("Todas las modificaciones se han realizado correctamente.");
    }


    // Método para dar de alta a un trabajador, en el caso de que no haya 2 instanciados en el main
    public void altaTrabajador(Scanner sc) {
        if (!trabajador3.getNombre().isEmpty()) {
            System.out.println("La base de datos de trabajadores está llena. ");
        } else {
            System.out.println("====== ALTA NUEVO TRABAJADOR ======");
            System.out.print("Introduce el nombre: ");
            String nombre = sc.nextLine();
            trabajador3.setNombre(nombre);
            System.out.print("Introduce los apellidos: ");
            String apellidos = sc.nextLine();
            trabajador3.setApellidos(apellidos);
            System.out.print("Introduce el correo electrónico: ");
            String correo = sc.nextLine();
            trabajador3.setCorreo(correo);
            System.out.print("Introduce la clave: ");
            String clave = sc.nextLine();
            trabajador3.setClave(clave);

            System.out.printf("El trabajador %s ha sido dado de alta correctamente.\n", nombre);

        }
    }

    // Método que le muestra todos los pedidos al admin
    public String verPedidosAdmin() {
        String resultado = "";
        resultado += (cliente1.getPedido1() == null) ? "" : cliente1.getPedido1().pintaPedido();
        resultado += (cliente1.getPedido2() == null) ? "" : cliente1.getPedido2().pintaPedido();
        resultado += (cliente2.getPedido1() == null) ? "" : cliente2.getPedido1().pintaPedido();
        resultado += (cliente2.getPedido2() == null) ? "" : cliente2.getPedido2().pintaPedido();

        return resultado;
    }

    // Método que le muestra los datos de los clientes al admin
    public String verClientesAdmin() {
        String resultado = "";
        resultado += (cliente1 == null) ? "" : cliente1.pintaCliente();
        resultado += (cliente2 == null) ? "" : cliente2.pintaCliente();

        return resultado;
    }

    // Método que le muestra los datos de los trabajadores al admin
    public String verTrabajadoresAdmin() {
        String resultado = "";
        resultado += (trabajador1.getNombre().isEmpty()) ? "" : trabajador1.pintaTrabajador();
        resultado += (trabajador2.getNombre().isEmpty()) ? "" : trabajador2.pintaTrabajador();
        resultado += (trabajador3.getNombre().isEmpty()) ? "" : trabajador3.pintaTrabajador();

        return resultado;
    }
}
