/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import main.java.com.mycompany.proyecto_final.Estructura.Mapa;
import main.java.com.mycompany.proyecto_final.Grafos.Grafo;
import main.java.com.mycompany.proyecto_final.Estructura.Lectura_Archivos;


public class Proyecto_Final {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Mapa mapa;
        System.out.println("Hello World!");
        Lectura_Archivos.leerArchivo(grafo);
        grafo.graficar_Auto();
        mapa = new Mapa(grafo);
        mapa.setLocationRelativeTo(null);
        mapa.setVisible(true);
        mapa.colocarGrafo();
        grafo.elegir();
        
        //grafo.graficar_Caminando();
        
    }
}
