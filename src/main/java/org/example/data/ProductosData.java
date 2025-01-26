package org.example.data;


import org.example.models.Producto;

// Base de datos con 12 productos para trabajar con ellos
public class ProductosData {
    public static Producto producto1 = new Producto("ABC123", "Harry Potter y la Piedra Filosofal", 12.99F);
    public static Producto producto2 = new Producto("DEF456", "Viento y verdad", 33.16F);
    public static Producto producto3 = new Producto("54SFDS", "Las que no duermen", 22.71F);
    public static Producto producto4 = new Producto("BVN778", "Victoria", 21.76F);
    public static Producto producto5 = new Producto("456DFGD", "La isla de la mujer dormida", 21.76F);
    public static Producto producto6 = new Producto("BNV878D", "La asistenta", 18.90F);
    public static Producto producto7 = new Producto("121F1D", "545 recetas para triunfar", 24.61F);
    public static Producto producto8 = new Producto("5D5DG54", "El niño que perdió la guerra", 23.66F);
    public static Producto producto9 = new Producto("X4S7D8", "Una Navidad muy fun, fun fun", 19.85F);
    public static Producto producto10 = new Producto("KJLHG5", "Todo Muere", 23.66F);
    public static Producto producto11 = new Producto("SD59AD", "Un corazón por Navidad", 16.10F);
    public static Producto producto12 = new Producto("GY7WF5V", "El clan", 20.81F);

    // Método para pintar el catálogo de los 12 productos que insertamos en la clase ProductosData
    public static String pintaCatalogo() {
        String resultado = "";
        resultado += "\nCATÁLOGO DE PRODUCTOS\n";
        resultado += "==========================\n";
        resultado += producto1.pintaProducto() + "\n";
        resultado += producto2.pintaProducto() + "\n";
        resultado += producto3.pintaProducto() + "\n";
        resultado += producto4.pintaProducto() + "\n";
        resultado += producto5.pintaProducto() + "\n";
        resultado += producto6.pintaProducto() + "\n";
        resultado += producto7.pintaProducto() + "\n";
        resultado += producto8.pintaProducto() + "\n";
        resultado += producto9.pintaProducto() + "\n";
        resultado += producto10.pintaProducto() + "\n";
        resultado += producto11.pintaProducto() + "\n";
        resultado += producto12.pintaProducto() + "\n";

        return resultado;
    }
}

