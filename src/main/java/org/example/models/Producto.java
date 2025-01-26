package org.example.models;

import java.util.Scanner;

import static org.example.data.ProductosData.*;

public class Producto {
    private String isbn;
    private String nombre;
    private float precio;

    public Producto(String isbn, String nombre, float precio) {
        this.isbn = isbn;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Método para modificar alguno de los atributos de la base de datos de productos
    public static void modificarProducto() {
        Scanner sc = new Scanner(System.in);
        int op;

        System.out.print("""
                    ¿Qué producto quieres modificar?
                    1. Harry Potter y la Piedra Filosofal
                    2. Viento y verdad
                    3. Las que no duermen
                    4. Victoria
                    5. La isla de la mujer dormida
                    6. La asistenta
                    7. 545 recetas para triunfar
                    8. El niño que perdió la guerra
                    9. Una Navidad muy fun, fun fun
                    10. Todo Muere
                    11. Un corazón por Navidad
                    12. El clan
                    13. Salir
                    Introduce una opción: 
                    """);
        op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1 -> modificaAtributo(producto1);
            case 2 -> modificaAtributo(producto2);
            case 3 -> modificaAtributo(producto3);
            case 4 -> modificaAtributo(producto4);
            case 5 -> modificaAtributo(producto5);
            case 6 -> modificaAtributo(producto6);
            case 7 -> modificaAtributo(producto7);
            case 8 -> modificaAtributo(producto8);
            case 9 -> modificaAtributo(producto9);
            case 10 -> modificaAtributo(producto10);
            case 11 -> modificaAtributo(producto11);
            case 12 -> modificaAtributo(producto12);
            default -> System.out.println("Opción no válida");
        }
    }

    /* En el switch anterior se llama a modificaAtributo para modificar un atributo en concreto del producto
    que se ha seleccionado en el método anterior */
    public static void modificaAtributo(Producto producto) {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.print("""
                            ¿Qué atributo quieres modificar?
                            1. ISBN
                            2. Nombre
                            3. Precio
                            4. Volver
                            Introduce una opción: 
                            """);
        op = Integer.parseInt(sc.nextLine());
        switch (op) {
            case 1:
                System.out.println("Introduce el nuevo ISBN: ");
                String nuevoIsbn = sc.nextLine();
                producto.setIsbn(nuevoIsbn);
                System.out.println("ISBN cambiado correctamente.");
                break;
            case 2:
                System.out.println("Introduce el nuevo nombre: ");
                String nuevoNombre = sc.nextLine();
                producto.setNombre(nuevoNombre);
                System.out.println("Nombre cambiado correctamente.");
                break;
            case 3:
                System.out.println("Introduce el nuevo precio: ");
                String nuevoPrecio = sc.nextLine();
                producto.setIsbn(nuevoPrecio);
                System.out.println("Precio cambiado correctamente.");
                break;
            case 4:
                break;
            default:
                System.out.println("Opción incorrecta.");
        }
    }



    public String pintaProducto() {
        return "- " + nombre + " (" + precio + "€)";
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}

