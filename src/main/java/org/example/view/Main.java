package org.example.view;

import org.example.comunicaciones.Comunicaciones;
import org.example.models.*;
import java.util.Scanner;

import static org.example.comunicaciones.Comunicaciones.enviaMensajeTelegram;
import static org.example.data.ProductosData.*;
import static org.example.utils.Utils.*;

public class Main {
    // Se declaran las instancias estáticas para poder trabajar con ellas en el main
    static Cliente cliente1 = new Cliente("Juan", "Lafuente", "Calle 1", "Martos", "Jaén", 655874511, "cliente1fernanshop@gmail.com", "jlf123");
    static Cliente cliente2 = new Cliente("Pedro", "Conde", "Calle 144", "Jaén", "Jaén", 655441122, "cliente2fernanshop@gmail.com", "pecon467");
//    static Cliente cliente2 = null;

    static Trabajador trabajador1 = new Trabajador("Andrés", "González", "trabajador1fernanshop@gmail.com", "andgon58745");
    static Trabajador trabajador2 = new Trabajador("Ana", "Martínez", "cliente1fernanshop@gmail.com", "anamar645");
    static Trabajador trabajador3 = new Trabajador("Felipe", "Del Campo", "cliente2fernanshop@gmail.com", "fedelcam54");
//            static Trabajador trabajador3 = null;

    static Admin admin = new Admin("admin@gmail.com", "admin", cliente1, cliente2, trabajador1, trabajador2, trabajador3);


    public static void main(String[] args) throws NumberFormatException{
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            System.out.println("""
                      ___                       ___ _            \s
                     | __|__ _ _ _ _  __ _ _ _ / __| |_  ___ _ __\s
                     | _/ -_) '_| ' \\/ _` | ' \\\\__ \\ ' \\/ _ \\ '_ \\
                     |_|\\___|_| |_||_\\__,_|_||_|___/_||_\\___/ .__/
                                                            |_|  \s                                 
                              ⠀⠀⠀⠀⠀⢀⠤⣀⡀⠀⠀⠀⠀⠀⠀⢀⡠⠔⠲⣄⠀⠀⠀⠀⠀⠀
                              ⠀⠀⠀⠀⣰⢧⡀⠀⠈⠲⡀⠀⠀⠀⡰⠉⠀⣴⠞⠉⢦⠀⠀⠀⠀⠀
                              ⠀⠀⠀⠀⡇⠀⠉⠓⢄⠀⠘⡄⠀⢠⠁⢀⠞⠀⠀⣠⠏⠀⠀⠀⠀⠀
                              ⠠⣄⡀⠀⠈⢒⣄⡀⠀⠑⢄⠘⡍⡸⡠⠊⣀⡤⢎⣁⠀⠀⠀⠀⠀⠀
                              ⡦⢌⣆⠀⠉⠉⠉⠉⠑⠒⣠⡬⠟⢻⡶⣚⣒⠠⠶⠈⣉⣁⣒⣠⡤⣄
                              ⠃⠀⠀⠉⠛⠿⠍⣉⠭⠑⠒⠈⠁⠈⠁⠒⠤⢀⠉⢙⣭⠩⠑⠂⠉⡸
                              ⠸⡤⣀⡀⠀⠀⠀⡇⠈⠁⠒⠠⠄⠤⠄⠐⠂⠈⡇⠀⢸⠀⠀⠀⣀⡧
                              ⠀⡇⠀⠈⠙⡀⠀⣇⡀⠀⠀⠀⡀⠀⠀⠀⠀⠀⡇⠀⢸⠔⠒⠉⠁⠁
                              ⠀⢿⠀⠀⠀⡇⠀⡇⠈⠑⠲⠤⣇⠤⠤⠒⠊⠉⠁⠀⢸⠀⠀⠀⢰⠀
                              ⠀⢸⠀⠀⠀⠁⠀⡇⠀⠀⠀⠀⠁⠀⠀⠀⠀⠀⠀⠀⢸⠀⠀⠀⢸⠀
                              ⠀⢸⠀⠀⠀⢸⠀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡀⠀⠀⠀⢸⠀
                              ⠀⣼⠀⠀⠀⢸⠀⢰⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠀⠀⡇⠀⠀⠀⢸⠀
                              ⠀⠓⠦⠤⣀⣸⠀⢸⠀⠀⠀⠀⠐⠀⠀⠀⠀⢸⠀⠀⠇⣀⣀⠤⠜⠀
                              ⠀⠀⠀⠀⠀⠈⠑⠒⠤⣀⠀⠀⠀⠀⠀⣀⡤⠼⠒⠊⠉⠀⠀⠀⠀⠀
                              ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⠶⠚⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀                                               
                                      
                    ¿Quién eres?
                    =====================                                                                      
                    1. Soy cliente
                    2. Soy trabajador
                    3. Soy administrador
                    4. Salir
                    """);
            System.out.print("Selecciona una opción: ");
            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Introduce una opción correcta");
            }
            

            /* Cada uno de los perfiles tiene un solo método. Dentro de él se llamarán a los métodos
            menuCliente, menuTrabajador o menuAdmin, que contendrán su correspondiente lógica */

            switch (op) {
                case 1:
                    gestionCliente(sc);
                    break;
                case 2:
                    gestionTrabajador(sc);
                    System.out.println();
                    break;
                case 3:
                    gestionAdmin(sc);
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;
            }
        } while (op != 4);
    }



    // Método que nos permitirá iniciar sesión o bien registrar a un nuevo cliente
    public static void gestionCliente(Scanner sc) throws NumberFormatException{
        int op = 0;

        do {
            System.out.print("""
            \n¿Qué quieres hacer?
            1. Iniciar sesión
            2. Darte de alta
            3. Volver
            Selecciona una opción:
            """);

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número.");
                return;
            }

            switch (op) {
                case 1 :
                    iniciarSesionCliente(sc);
                    break;
                case 2:
                    registrarNuevoCliente(sc);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Opción no válida, vuelve a intentarlo.");
            }
        } while (op != 3);
    }

    // Método para el inicio de sesión del cliente
    public static void iniciarSesionCliente(Scanner sc) {

        System.out.println();
        System.out.println("Introduce tu correo electrónico: ");
        String correoLogin = sc.nextLine();
        System.out.println("Introduce la clave: ");
        String claveLogin = sc.nextLine();

        Cliente clienteLogueado = null;

        if (correoLogin.equals(cliente1.getCorreo()) && claveLogin.equals(cliente1.getClave())) {
            System.out.println();
            System.out.println("Inicio de sesión correcto");
            clienteLogueado = cliente1;
        } else if (correoLogin.equals(cliente2.getCorreo()) && claveLogin.equals(cliente2.getClave())) {
            System.out.println();
            System.out.println("Inicio de sesión correcto");
            clienteLogueado = cliente2;
        }

        if (clienteLogueado != null) {
            menuCliente(sc, clienteLogueado);
        } else {
            System.out.println();
            System.out.println("Credenciales incorrectas.");
        }
    }

    // Método para registrar a un nuevo cliente, en el caso de que los 2 del main estén instanciados saltará un mensaje y un return

    public static void registrarNuevoCliente(Scanner scanner) {
        if (cliente1 == null) {
            cliente1 = new Cliente();
            llenarDatosCliente(scanner, cliente1);
        } else if (cliente2 == null) {
            cliente2 = new Cliente();
            llenarDatosCliente(scanner, cliente2);
        } else {
            System.out.println("La base de datos de clientes está llena.");
        }
    }

    public static void llenarDatosCliente(Scanner scanner, Cliente cliente) throws NumberFormatException {
        boolean ok = false;
        int token = cliente.generaToken();
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);
        System.out.print("Introduce tus apellidos: ");
        String apellidos = scanner.nextLine();
        cliente.setApellidos(apellidos);
        System.out.print("Introduce tu dirección: ");
        String direccion = scanner.nextLine();
        cliente.setDireccion(direccion);
        System.out.print("Introduce tu localidad: ");
        String localidad = scanner.nextLine();
        cliente.setLocalidad(localidad);
        System.out.print("Introduce tu provincia: ");
        String provincia = scanner.nextLine();
        cliente.setProvincia(provincia);

        do {
            try {
                System.out.print("Introduce tu teléfono: ");
                int telefono = Integer.parseInt(scanner.nextLine());
                cliente.setTelefono(telefono);
                ok = true;
            } catch (NumberFormatException nfe) {
                System.out.println("El valor introducido debe ser un número.");
            }
        } while (!ok);


        do {
            System.out.print("Introduce tu correo electrónico: ");
            String correo = scanner.nextLine();
            cliente.setCorreo(correo);
            if (cliente.getCorreo().equals(cliente1.getCorreo())) System.out.println("Ese correo ya está en uso.");
        } while (cliente.getCorreo().equals(cliente1.getCorreo()));

        System.out.print("Introduce tu clave: ");
        String clave = scanner.nextLine();
        cliente.setClave(clave);

        System.out.println();
        System.out.println("Alta realizada correctamente");
        System.out.println("Un momento por favor...");

        enviaTokenMailCliente(token, cliente.getCorreo(), cliente.getNombre());

        int tokenUsuario = 0;
        do {
            System.out.println("Introduce el token que has recibido en el mail para continuar:");
            tokenUsuario = Integer.parseInt(scanner.nextLine());

            if (tokenUsuario != token) System.out.println("Token incorrecto.");
        } while (tokenUsuario != token);

        System.out.println("Token correcto. Bienvenido a FernanShop, " + cliente.getNombre());

    }


    public static void enviaTokenMailCliente(int token, String correo, String nombreCliente) {

        String destinatario = correo;
        String asunto = "BIENVENIDO A FERNANSHOP, AQUÍ TIENES TU TOKEN DE BIENVENIDA";
        String cuerpo = "<img src='https://i.postimg.cc/C1yV7PDS/Captura-de-pantalla-2025-01-16-105520.jpg' alt='Logo' />";
        cuerpo += "<h2> Estimado " + nombreCliente + " aquí tienes tu token de bienvenida: " + token + "</h2>";

        Comunicaciones.enviarCorreoGmail(destinatario, asunto, cuerpo);

    }



    // Método para realizar un nuevo pedido para el cliente
    public static void realizarPedido(Scanner sc, Cliente cliente) {
        if (cliente.getPedido1() != null && cliente.getPedido2() != null) {
            System.out.println("No es posible realizar más de 2 pedidos.");
            return;
        }

        // El método crearPedido es el que muestra los productos y nos va pidiendo más (hasta un máximo de 3)
        Pedido nuevoPedido = creaPedido(sc, cliente);

        if (cliente.getPedido1() == null) {
            cliente.setPedido1(nuevoPedido);
        } else if (cliente.getPedido2() == null) {
            cliente.setPedido2(nuevoPedido);
        }

        // Este método es el que, a la vez que el cliente crea un pedido, se le asigna a uno de los 3 trabajadores
        asignaPedidoClienteATrabajador(nuevoPedido);
    }

    public static Pedido creaPedido(Scanner sc, Cliente cliente) {
        boolean continuar;
        Pedido pedido;
        System.out.println(pintaCatalogo());
        System.out.println();

        do {
            pedido = new Pedido(cliente, null);

            if (cliente1 != null) {
                if (cliente1.getPedido1() != null && cliente1.getPedido1().getIdPedido().equals(pedido.getIdPedido())) continuar = false;
                else if (cliente1.getPedido2() != null && cliente1.getPedido2().getIdPedido().equals(pedido.getIdPedido())) continuar = false;
                else continuar = true;
            } else if (cliente2 != null) {
                if (cliente2.getPedido1() != null && cliente2.getPedido1().getIdPedido().equals(pedido.getIdPedido())) continuar = false;
                else if (cliente2.getPedido1() != null && cliente2.getPedido2().getIdPedido().equals(pedido.getIdPedido())) continuar = false;
                else continuar = true;
            } else continuar = true;
        } while (!continuar);


        for (int i = 1; i <= 3; i++) {
            String productoCarrito;
            do {
                System.out.println("¿Qué producto quieres añadir al carrito?");
                productoCarrito = sc.nextLine();
                if (!compruebaProducto(productoCarrito)) System.out.println("Ese producto no existe.");
            } while (!compruebaProducto(productoCarrito));

            // Asignar el producto al carrito según el índice
            if (i == 1) pedido.setProducto1(aniadeProductoCarrito(productoCarrito));
            else if (i == 2) pedido.setProducto2(aniadeProductoCarrito(productoCarrito));
            else pedido.setProducto3(aniadeProductoCarrito(productoCarrito));

            System.out.println("Producto añadido.");

            // Preguntar si el cliente desea añadir más productos, excepto en el último ciclo
            if (i < 3) {
                System.out.println("¿Quieres añadir más productos al carrito? (si/no)");
                String quieresMas = sc.nextLine();
                if (quieresMas.equalsIgnoreCase("no")) i = 3;
            }
        }

        System.out.println("Pedido realizado correctamente.");
        return pedido; // Devolver el pedido nuevo
    }

    // Método que nos devuelve un producto y lo añade al pedido del cliente
    public static Producto aniadeProductoCarrito(String productoCarrito) {
        if (productoCarrito.equalsIgnoreCase(producto1.getNombre())) return producto1;
        else if (productoCarrito.equalsIgnoreCase(producto2.getNombre())) return producto2;
        else if (productoCarrito.equalsIgnoreCase(producto3.getNombre())) return producto3;
        else if (productoCarrito.equalsIgnoreCase(producto4.getNombre())) return producto4;
        else if (productoCarrito.equalsIgnoreCase(producto5.getNombre())) return producto5;
        else if (productoCarrito.equalsIgnoreCase(producto6.getNombre())) return producto6;
        else if (productoCarrito.equalsIgnoreCase(producto7.getNombre())) return producto7;
        else if (productoCarrito.equalsIgnoreCase(producto8.getNombre())) return producto8;
        else if (productoCarrito.equalsIgnoreCase(producto9.getNombre())) return producto9;
        else if (productoCarrito.equalsIgnoreCase(producto10.getNombre())) return producto10;
        else if (productoCarrito.equalsIgnoreCase(producto11.getNombre())) return producto11;
        else if (productoCarrito.equalsIgnoreCase(producto12.getNombre())) return producto12;
        return null;
    }

    // Método que comprueba si el nombre del producto que se quiere añadir al carrito existe o no
    public static boolean compruebaProducto(String productoCarrito) {
        if (productoCarrito.equalsIgnoreCase(producto1.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto2.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto3.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto4.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto5.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto6.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto7.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto8.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto9.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto10.getNombre())) return true;
        else if (productoCarrito.equalsIgnoreCase(producto11.getNombre())) return true;
        else return productoCarrito.equalsIgnoreCase(producto12.getNombre());
    }

    // Método que se llama cuando un cliente realiza un pedido, para asginar dicho pedido a un trabajador
    public static void asignaPedidoClienteATrabajador(Pedido pedido) {
        if (trabajador1.cuentaPedidos() < 2 || trabajador2.cuentaPedidos() < 2 || trabajador3.cuentaPedidos() < 2) {
            Trabajador trabajadorAsignado;

            if (trabajador1.cuentaPedidos() <= trabajador2.cuentaPedidos() && trabajador1.cuentaPedidos() <= trabajador3.cuentaPedidos()) {
                trabajadorAsignado = trabajador1;
                System.out.println("Un momento por favor...");
                mandaMailTrabajador(pedido, trabajadorAsignado);

            } else if (trabajador2.cuentaPedidos() <= trabajador1.cuentaPedidos() && trabajador2.cuentaPedidos() <= trabajador3.cuentaPedidos()) {
                trabajadorAsignado = trabajador2;
                System.out.println("Un momento por favor...");
                mandaMailTrabajador(pedido, trabajadorAsignado);
            } else {
                trabajadorAsignado = trabajador3;
                System.out.println("Un momento por favor...");
                mandaMailTrabajador(pedido, trabajadorAsignado);
            }

            if (trabajadorAsignado.getPedido1() == null) trabajadorAsignado.setPedido1(pedido);
            else trabajadorAsignado.setPedido2(pedido);

            pedido.setEstado("En preparación");
            System.out.println("Pedido asignado al repartidor/a " + trabajadorAsignado.getNombre());
            enviaMensajeTelegram("Tienes un nuevo pedido asignado: " + pedido.getIdPedido() + ". Revisa tu correo electrónico");
        } else {
            System.out.println("No hay trabajadores disponibles para asignar el pedido.");
        }
    }

    public static void mailModificaPedidoTrabajador(Pedido pedido, Trabajador trabajador, String correo) {
        String destinatario = correo;
        String asunto = "MODIFICACIÓN ESTADO PEDIDO " + pedido.getIdPedido() + " PARA " + trabajador.getNombre();

        String resultado = "";
        resultado += "<br><h1>=========== Pedido " + pedido.getIdPedido() + " ===========</h1>" +
                "<br>" + "<p><b>Estado: </b>" + pedido.getEstado() +
                "<br><b>Cliente: </b>" + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellidos() +
                "<br><b>Dirección: </b>" + pedido.getCliente().getDireccion() +
                "<br><b>Localidad: </b>" + pedido.getCliente().getLocalidad() +
                "<br><b>Provincia: </b>" + pedido.getCliente().getProvincia() +
                "<br><b>Teléfono: </b>" + pedido.getCliente().getTelefono() +
                "<br><b>Correo: </b>" + pedido.getCliente().getCorreo() +
                "<br><b>Fecha del pedido: </b>" + pedido.getFechaPedido() +
                "<br><b>Fecha de entrega estimada: </b>" + pedido.getFechaEntrega() +
                "<br><b>Comentario del pedido: </b>" + pedido.getComentario() +
                "<br><b>Detalles del pedido: </b>" +
                "<br>" + ((pedido.getProducto1() == null) ? "" : pedido.getProducto1().pintaProducto()) +
                "<br>" + ((pedido.getProducto2() == null) ? "" : pedido.getProducto2().pintaProducto()) +
                "<br>" + ((pedido.getProducto3() == null) ? "" : pedido.getProducto3().pintaProducto()) +
                "<br><b>Total pedido: </b>" + pedido.getTotalPedido() + "€" +
                "<br><br><h1>==================================</h1>";



        String cuerpo = "<img src='https://i.postimg.cc/C1yV7PDS/Captura-de-pantalla-2025-01-16-105520.jpg' alt='Logo' />";
        cuerpo += "<br><h1> DESGLOSE DE PEDIDO </h1>";
        cuerpo += resultado;

        Comunicaciones.enviarCorreoGmail(destinatario, asunto, cuerpo);
    }



    public static void mandaMailTrabajador(Pedido pedido, Trabajador trabajador) {
        String destinatario = trabajador.getCorreo();
        String asunto = "CONFIRMACIÓN DE PEDIDO " + pedido.getIdPedido() + " PARA " + trabajador.getNombre();

        String resultado = "";
        resultado += "<br><h2>=========== Pedido " + pedido.getIdPedido() + " ===========</h2>" +
                "<br>" + "<p><b>Estado: </b>" + pedido.getEstado() +
                "<br><b>Cliente: </b>" + pedido.getCliente().getNombre() + " " + pedido.getCliente().getApellidos() +
                "<br><b>Dirección: </b>" + pedido.getCliente().getDireccion() +
                "<br><b>Localidad: </b>" + pedido.getCliente().getLocalidad() +
                "<br><b>Provincia: </b>" + pedido.getCliente().getProvincia() +
                "<br><b>Teléfono: </b>" + pedido.getCliente().getTelefono() +
                "<br><b>Correo: </b>" + pedido.getCliente().getCorreo() +
                "<br><b>Fecha del pedido: </b>" + pedido.getFechaPedido() +
                "<br><b>Fecha de entrega estimada: </b>" + pedido.getFechaEntrega() +
                "<br><b>Comentario del pedido: </b>" + pedido.getComentario() +
                "<br><b>Detalles del pedido: </b>" +
                "<br>" + ((pedido.getProducto1() == null) ? "" : pedido.getProducto1().pintaProducto()) +
                "<br>" + ((pedido.getProducto2() == null) ? "" : pedido.getProducto2().pintaProducto()) +
                "<br>" + ((pedido.getProducto3() == null) ? "" : pedido.getProducto3().pintaProducto()) +
                "<br><b>Total pedido: </b>" + pedido.getTotalPedido() + "€" +
                "<br><br><h2>==================================</h2>";


        String cuerpo = "<img src='https://i.postimg.cc/C1yV7PDS/Captura-de-pantalla-2025-01-16-105520.jpg' alt='Logo' />";
        cuerpo += "<br><h2> DESGLOSE DE PEDIDO </h2>";
        cuerpo += resultado;

        Comunicaciones.enviarCorreoGmail(destinatario, asunto, cuerpo);
    }

    // Método para el inciio de sesión de un trabajador, que comprueba el correo y la clave de cada uno de ellos
    public static void gestionTrabajador(Scanner sc){
        System.out.println();
        System.out.println("Introduce tu correo electrónico: ");
        String correoLogin = sc.nextLine();
        System.out.println("Introduce la clave: ");
        String claveLogin = sc.nextLine();

        Trabajador trabajadorLogueado = null;

        if (correoLogin.equals(trabajador1.getCorreo()) && claveLogin.equals(trabajador1.getClave())) {
            System.out.println();
            System.out.println("Inicio de sesión correcto");
            trabajadorLogueado = trabajador1;
        } else if (correoLogin.equals(trabajador2.getCorreo()) && claveLogin.equals(trabajador2.getClave())) {
            System.out.println();
            System.out.println("Inicio de sesión correcto");
            trabajadorLogueado = trabajador2;
        } else if (correoLogin.equals(trabajador3.getCorreo()) && claveLogin.equals(trabajador3.getClave())) {
            System.out.println();
            System.out.println("Inicio de sesión correcto");
            trabajadorLogueado = trabajador3;
        }

        if (trabajadorLogueado != null) {
            menuTrabajador(sc, trabajadorLogueado);
        } else {
            System.out.println();
            System.out.println("Credenciales incorrectas.");
        }
    }

    // Método para el inicio de sesión del administrador
    public static void gestionAdmin(Scanner sc) {
        System.out.println();
        System.out.println("Introduce tu correo electrónico: ");
        String correoLogin = sc.nextLine();
        System.out.println("Introduce la clave: ");
        String claveLogin = sc.nextLine();

        if (correoLogin.equals(admin.getUsuario()) && claveLogin.equals(admin.getClave())) {
            menuAdmin(sc, admin);
        } else {
            System.out.println("Credenciales incorrectas...");
        }
    }

    public static void menuCliente(Scanner sc, Cliente cliente) {
        int op;
        do {
            System.out.println();
            System.out.printf("""
                    FERNANSHOP
                    Bienvenido, %s
                    1. Consultar el catálogo de productos
                    2. Realizar un pedido
                    3. Ver mis pedidos realizados
                    4. Ver mis datos personales
                    5. Modificar mis datos personales
                    6. Cerrar sesión
                    Selecciona una opción:
                    """, cliente.getNombre());
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    System.out.println(pintaCatalogo());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 2:
                    realizarPedido(sc, cliente);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    System.out.println(cliente.pintaPedidosCliente());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 4:
                    System.out.println(cliente.pintaCliente());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 5:
                    modificaDatosCliente(sc, cliente);
                    break;
                case 6:
                    System.out.println("Cerrando sesión...");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                default:
                    System.out.println("Opción no válida.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
            }
        } while (op != 6);
    }

    // Método para modificar alguno de los atributos del cliente, con un switch
    public static void modificaDatosCliente(Scanner sc, Cliente cliente) throws NumberFormatException {
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
                    cliente.setNombre(nuevoNombre);
                    System.out.println("Nombre cambiado correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;

                case 2:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevoApellido = sc.nextLine();
                    cliente.setApellidos(nuevoApellido);
                    System.out.println("Apellidos cambiados correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaDireccion = sc.nextLine();
                    cliente.setDireccion(nuevaDireccion);
                    System.out.println("Dirección cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 4:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaLocalidad = sc.nextLine();
                    cliente.setLocalidad(nuevaLocalidad);
                    System.out.println("Localidad cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 5:
                    System.out.print("Introduce el nuevo valor: ");
                    String nuevaProvincia = sc.nextLine();
                    cliente.setProvincia(nuevaProvincia);
                    System.out.println("Provincia cambiada correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 6:
                    System.out.print("Introduce el nuevo valor: ");
                    int nuevoTelefono = Integer.parseInt(sc.nextLine());
                    cliente.setTelefono(nuevoTelefono);
                    System.out.println("Teléfono cambiado correctamente.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 7:
                    String nuevoCorreo = "";
                    do {
                        System.out.print("Introduce el nuevo valor: ");
                        nuevoCorreo = sc.nextLine();
                        if (nuevoCorreo.equals(cliente2.getCorreo())) System.out.println("Ese correo ya está en uso, elige otro.");
                    } while (nuevoCorreo.equals(cliente2.getCorreo()));
                    cliente.setCorreo(nuevoCorreo);
                    int token = cliente.generaToken();
                    int tokenUsuario;
                    System.out.println("Un momento por favor...");
                    enviaTokenMailCliente(token, nuevoCorreo, cliente.getNombre());
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
                    cliente.setClave(nuevaClave);
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

    public static void menuTrabajador(Scanner sc, Trabajador trabajador) throws  NumberFormatException{
        Admin admin = new Admin();
        int op = 0;
        do {
            System.out.printf("""
                FERNANSHOP
                Bienvenido, %s. Tienes %d pedidos que gestionar
                1. Consultar los pedidos que tengo asignados
                2. Modificar el estado de un pedido
                3. Consultar el catálogo de productos
                4. Modificar un producto del catálogo
                5. Ver mi perfil
                6. Modificar mis datos personales
                7. Cerrar sesión
                Selecciona una opción:
                """, trabajador.getNombre(), trabajador.cuentaPedidos());

            try {
                op = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción incorrecta.");
            }


            switch (op) {
                case 1:
                    System.out.println(trabajador.consultaPedidos());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 2:
                    admin.modificaEstadoPedidoTrabajador(sc, trabajador);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    System.out.println(pintaCatalogo());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 4:
                    Producto.modificarProducto();
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 5:
                    System.out.println(trabajador.pintaTrabajador());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 6:
                    trabajador.modificaDatosTrabajador(sc);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
            }
        } while (op != 7);
    }


    public static void menuAdmin(Scanner sc, Admin admin) {
        int op;
        do {
            System.out.println();

            System.out.printf("""
                    FERNANSHOP
                    Bienvenido Admin. Tienes %d pedidos por asignar
                    1. Asignar un pedido a un trabajador
                    2. Modificar el estado de un pedido
                    3. Dar de alta un trabajador
                    4. Ver todos los pedidos
                    5. Ver todos los clientes
                    6. Ver todos los trabajadores
                    7. Cerrar sesión
                    Selecciona una opción:
                    """, admin.getContadorPedidos());
            op = Integer.parseInt(sc.nextLine());

            switch (op) {
                case 1:
                    admin.asignaPedidoAdmin(sc);
                    pulsaParaContinuar();
                    break;
                case 2:
                    admin.menuModificaEstadoAdmin(sc);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 3:
                    admin.altaTrabajador(sc);
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 4:
                    System.out.println(admin.verPedidosAdmin());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 5:
                    System.out.println(admin.verClientesAdmin());
                    System.out.println();
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 6:
                    System.out.println(admin.verTrabajadoresAdmin());
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Opción no válida.");
                    pulsaParaContinuar();
                    limpiaPantalla();
                    break;
            }
        } while (op != 7);
    }



}