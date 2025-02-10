/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.ejercicios.controles;

import edu.itz.ejercicios.vistas.Ventana;

/**
 *
 * @author exodu
 */
public class Control {
    
    Ventana v;
    
    public Control(Ventana v) {
        this.v = v;
    }
    
    public void abrirArchivo() {
        v.getTxtContenido().setText("Hola mundo");
    }
    
    public void limpiar() {
        v.getTxtContenido().setText("");
    }
    
}
