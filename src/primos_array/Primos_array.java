/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primos_array;


import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author yai
 */
public class Primos_array {

    // CONSTANTE
    public static String RUTA = "numeros.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> primos = new ArrayList<>();
        utilidades.existeFichero();
        boolean salir = false;
        do {
            System.out.println("1. Almacenar más primos.");
            System.out.println("2. Ver almacén de primos.");
            System.out.println("3. Salir.");
            System.out.println("");
            System.out.print("Elige una opción: ");
            String opcion = sc.next();
            switch (opcion) {
                case "1":
                    System.out.println("1. ¿Cuántos números primos quieres añadir?");
                    int num = sc.nextInt();
                    boolean limite = false;
                    int cont = 0;
                    for (int i = utilidades.leerUltimo()+1; i >= 0 && !limite; i++) {
                        if (utilidades.NumeroPrimo(i)) {
                            cont = cont + 1;
                            primos.add(i);
                        }
                        if (cont == num) {
                            limite = true;
                        }
                    }
                    utilidades.escribirFichero(primos);
                    break;
                case "2":
                    utilidades.leerFichero();
                    int cantidad = utilidades.cantidadFichero();
                    System.out.println("Tiene un total de: " + cantidad + " número primos almacenados.");
                    System.out.println("");
                    break;
                case "3":
                    salir = true;
                    System.out.println("");
                    System.out.println("Nos vemos pronto :)");
                    break;
                default:
                    System.out.println("Solo números del 1 al 2.");
            }
        } while (!salir);
    }
}
