package org.example.utils;

import java.util.Scanner;

public class Utils {
    /*
    Aquí he creado tanto el pulsaParaContinuar, limpiaPantalla como el menú de cada
    uno de los perfiles de nuestra tienda. Desde el main, cuando seleccionamos un perfil específico
    se llama a menuCliente, menuTrabajador o menuAdmin, que a su vez tienen sus métodos dentro de
    cada una de las opciones de su menú en el switch
     */
    public static void pulsaParaContinuar() {
        var sc = new Scanner(System.in);
        System.out.println("Pulsa una tecla + Intro para continuar...");
        sc.nextLine();
    }

    public static void limpiaPantalla() {
        for (int i = 0; i < 100; i++) {
            System.out.println();
        }
    }


}