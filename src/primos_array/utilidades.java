/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primos_array;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static primos_array.Primos_array.RUTA;

/**
 *
 * @author yai
 */
public class utilidades {
    
    public static boolean NumeroPrimo(int num) {
        boolean primo = true;
        if (num <= 1) {
            primo = false;
        }
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                primo = false;
                break;
            }
        }
        return primo;
    }

    public static void existeFichero() {
        File fichero = new File(RUTA);
        try {
            if (!fichero.exists()) {
                fichero.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Mensaje de la excepción: " + e.getMessage());
        }
    }

    public static void escribirFichero(ArrayList<Integer> primos) {
        File fichero = new File(RUTA);
        try {
            FileOutputStream f = new FileOutputStream(fichero);
            ObjectOutputStream s = new ObjectOutputStream(f);
            s.writeObject(primos);
            s.close();
        } catch (IOException ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        } 
    }

    public static void leerFichero() {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        try {
            FileInputStream f = new FileInputStream(fichero);
            ObjectInputStream s = new ObjectInputStream(f);
            ArrayList<Integer> primos = (ArrayList<Integer>) s.readObject();
            for (Integer cadena : primos) {
                System.out.print(cadena + " ");
            }
            System.out.println("");
            s.close();
        } catch (IOException e) {
            System.out.println("El fichero esta vacio.");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Primos_array.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static int leerUltimo() {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        int ultimoprimo=0;
        try {
            FileInputStream f = new FileInputStream(fichero);
            ObjectInputStream s = new ObjectInputStream(f);
            ArrayList<Integer> primos = (ArrayList<Integer>) s.readObject();
            int sprimos=primos.size()-1;
            ultimoprimo=primos.get(sprimos);
            s.close();
        } catch (IOException e) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Primos_array.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimoprimo;
    }
    
    public static int cantidadFichero() {
        // Creamos un objeto fichero
        // File fichero = new File("mascotas.info");
        File fichero = new File(RUTA);
        int ultimoprimo=0;
        try {
            FileInputStream f = new FileInputStream(fichero);
            ObjectInputStream s = new ObjectInputStream(f);
            ArrayList<Integer> primos = (ArrayList<Integer>) s.readObject();
            ultimoprimo=primos.size();
            s.close();
        } catch (IOException e) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Primos_array.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimoprimo;
    }
}
