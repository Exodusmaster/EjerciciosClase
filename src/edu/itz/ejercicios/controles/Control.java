/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.itz.ejercicios.controles;

import edu.itz.ejercicios.vistas.Ventana;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
        //v.getTxtContenido().setText("Hola mundo");
        limpiar();
        //v.getTxtContenido().setText("");
        String path = null;
        JFileChooser fileChooser = new JFileChooser();
        int returnVAlue = fileChooser.showOpenDialog(v);// v es el companente no null por brechas de seguridad

        if (returnVAlue == JFileChooser.APPROVE_OPTION) {
            path = fileChooser.getSelectedFile().getAbsolutePath();
            v.getLblArchivo().setText(path);

        }
        if (path == null) {
            JOptionPane.showMessageDialog(v, "No seleccionastes nada o diste cancelar");
            return;
        }

        leerArchivo(path);

    }

    public void limpiar() {
        v.getTxtContenido().setText("");
        v.getLblArchivo().setText("");
        v.getTxtSalida().setText("");
    }

    public void leerArchivo(String archivo) {
        String texto = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                texto += linea + "\n";

            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        v.getTxtContenido().append(texto + "\n");
    }

    public void contar() {
        String c = v.getTxtContenido().getText();
        //limpiar();
        // int letras = 0, numeros = 0, otros = 0;
        /* v.getTxtSalida().setText("Total: " + c.length() + "\n");
        char a = c.charAt(0);
        v.getTxtSalida().append("Inicial: " + a + "\n");
        for (int i = 0; i < c.length(); i++) {
            a = c.charAt(i);
            if (Character.isLetter(a)) {
                letras++;
            } else if (Character.isDigit(a)) {
                numeros++;
            } else {
                otros++;
            }
        }
        v.getTxtSalida().append("Letras: " + letras + "\n" + "numeros: " + numeros + "\n" + "otros: " + otros + "\n");*/

// Expresiones regulares

        /*9999*77881155
mom_123,779-adi_0s+marcha2025.33*/
//()equal , []OR
//[\\w\\s{3}]+ CUALQUIER FRASE a-z es un conjunto de identificadores para verificar un numero hexadecimal 0x[0-9A-F]+ para un RFC [A-Z]{3,4}(9\\d|[01]\\d|2[0-5])(0[1-9]|1[1-2])(0\\d|[12]\\d|3[0-1])([A-Z\\d]{3})
        if (c.matches("[[A-Za-z\\d\\W]+\\S]{8,}")) { //impar 0*10*(0*10*10*)* par 0*10*10*)+ [a-zA-Z][\\w]* identificadores [1-9]\\d* Numeros
            v.getTxtSalida().append("Si hace match"); //construyendo el segundo piso
        } else {
            v.getTxtSalida().append("No hace match");
        }
    }

    //¨a{4,} el 4 solo porque tinene que cumplir esa cantidad y la coma hacer que como minimo sean 4 doble // en el string de java
    //(?![.-])[\\w.-]+@[\\w.-]{2,}
    public void coincidencia() {
        String txtContenido = v.getTxtContenido().getText();
// Obtener el contenido del JTextArea

        // Expresiones regulares para identificadores y números
        String regexIdentificadores = "[a-zA-Z][a-zA-Z0-9_]*";  // Identificadores (solo letras y números, pero no solo números)
        String regexNumeros = "\\b[1-9]\\d*\\b";                   // Números enteros positivos (solo números independientes)

        // Compilar patrones
        Pattern patternIdentificadores = Pattern.compile(regexIdentificadores);
        Pattern patternNumeros = Pattern.compile(regexNumeros);

        int contadorIdentificadores = 0;
        int contadorNumeros = 0;

        // Contar identificadores
        Matcher matcherIdentificadores = patternIdentificadores.matcher(txtContenido);
        while (matcherIdentificadores.find()) {
            String identificador = matcherIdentificadores.group();
            // Verificamos si el identificador no es solo números (si no es un número puro)
            if (!identificador.matches("[0-9]+")) {
                System.out.println("Identificador encontrado: " + identificador);
                contadorIdentificadores++;
            }
        }

        // Contar números
        Matcher matcherNumeros = patternNumeros.matcher(txtContenido);
        while (matcherNumeros.find()) {
            System.out.println("Número encontrado: " + matcherNumeros.group());
            contadorNumeros++;
        }

        System.out.println("\nTotal Identificadores: " + contadorIdentificadores);
        System.out.println("Total Números: " + contadorNumeros);
        v.getTxtSalida().append("Total Identificadores: " + contadorIdentificadores + "\nTotal Números: " + contadorNumeros);
    }

    public void cuentaIdnum() {
        String texto = v.getTxtContenido().getText();
        v.getTxtSalida().setText("");
        String regexIdentificadores = "[a-zA-Z]\\w*";  // Identificadores (solo letras y números, pero no solo números)
        String regexNumeros = "[1-9]\\d*";
        Pattern patron = Pattern.compile("[a-zA-Z]\\w*|[1-9]\\d*|0");
        Matcher match = patron.matcher(texto);
        while (match.find()) {
            v.getTxtSalida().append(match.group() + "\n");

        }
    }

    //que es un componente lexico
    //AAAA o AAA 99 año del 90-25 88 01-12 Mes DIA 01
    public void idconAFD() {
        String txtAFD = v.getTxtContenido().getText();
        v.getTxtSalida().setText("");
        for (int i = 0; i < txtAFD.length(); i++) {
            char c = txtAFD.charAt(i);
            String id = "";

            if (Character.isLetter(c)) {
                id = "";
                while (i < txtAFD.length() && (Character.isLetterOrDigit(c) || c == '_')) {
                    id += c;
                    i++;
                    if (i >= txtAFD.length()) { // Verificamos que i no se pase
                        break; // Evitamos acceder fuera de rango
                    } else {

                        c = txtAFD.charAt(i);
                    }
                }
                v.getTxtSalida().append(id + "\n");
            }
            if (Character.isDigit(c)) {
                id = "";
                boolean hasPoint = false; // Para evitar más de un punto decimal

// Si el número empieza con '0'
                if (c == 'o') {
                    id += c;
                    if (++i < txtAFD.length()) {
                        c = txtAFD.charAt(i);
                        if (c == '.') { // Permitir decimal solo si sigue un punto
                            hasPoint = true;
                            id += c;
                            if (++i < txtAFD.length() && Character.isDigit(txtAFD.charAt(i))) {
                                c = txtAFD.charAt(i);
                                while (i < txtAFD.length() && Character.isDigit(c)) {
                                    id += c;
                                    if (++i < txtAFD.length()) {
                                        c = txtAFD.charAt(i);
                                    } else {
                                        break;
                                    }
                                }
                            }
                        }
                    }
                } else { // Si el número empieza con otro dígito
                    while (i < txtAFD.length() && Character.isDigit(c)) {
                        id += c;
                        if (++i < txtAFD.length()) {
                            c = txtAFD.charAt(i);
                        } else {
                            break;
                        }
                    }
                    if (i < txtAFD.length() && c == '.' && !hasPoint) { // Si hay un punto decimal
                        hasPoint = true;
                        id += c;
                        if (++i < txtAFD.length() && Character.isDigit(txtAFD.charAt(i))) {
                            c = txtAFD.charAt(i);
                            while (i < txtAFD.length() && Character.isDigit(c)) {
                                id += c;
                                if (++i < txtAFD.length()) {
                                    c = txtAFD.charAt(i);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }

            }

            if (c == '0') {
                id += c;
                c = txtAFD.charAt(i++); // Incremento después de capturar el carácter
                if (c == 'X') {
                    id += c;
                    c = txtAFD.charAt(i++); // Captura el siguiente carácter
                    while (i < txtAFD.length() && (Character.isDigit(c) || (c >= 'A' && c <= 'F'))) {
                        id += c;
                        if (i < txtAFD.length()) {
                            c = txtAFD.charAt(i++); // Captura el siguiente carácter
                        }
                    }
                    // Mostrar el valor después de completar la captura
                    v.getTxtSalida().append(id + "\n");
                } else {
                    break; // Si no es 'X', salimos del ciclo
                }
            } else {
                break; // Si no empieza con '0', salimos del ciclo
            }

            v.getTxtSalida().append(id + "\n");

        }

    }

}
