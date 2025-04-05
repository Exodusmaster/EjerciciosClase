/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package edu.itz.ejercicios;

import edu.itz.ejercicios.lexemas.Lexema;
import edu.itz.ejercicios.vistas.Ventana;
import java.util.ArrayList;

/**
 *
 * @author exodu
 */
public class EjerciciosClase {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Ventana v =new Ventana();
       // v.setVisible(true);
        ArrayList<Lexema> lexes = new ArrayList<>();
        Lexema l = new Lexema("Liz haz caso de las recom", 12);
        lexes.add(l);
        lexes.add(new Lexema("Bienvenidos a los objetos",41));
        for (Lexema lex : lexes) {
            System.out.println(lex);
        }
    }
    
}
