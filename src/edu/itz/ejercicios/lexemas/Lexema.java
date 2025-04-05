/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.ejercicios.lexemas;

/**
 *
 * @author exodu
 */
public class Lexema {
    private String elemento;
    private int token;

    public Lexema(String elemento, int token) {
        this.elemento = elemento;
        this.token = token;
    }

    public String getElemento() {
        return elemento;
    }

    public void setElemento(String elemento) {
        this.elemento = elemento;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "[" + token + "\t" + elemento + "]";
    }
    
}
