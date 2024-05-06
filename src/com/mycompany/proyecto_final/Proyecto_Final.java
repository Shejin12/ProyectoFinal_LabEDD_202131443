/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import com.mycompany.proyecto_final.Estructura.Mapa;
import main.java.com.mycompany.proyecto_final.Grafos.Grafo;
import main.java.com.mycompany.proyecto_final.Estructura.Lectura_Archivos;


/**
 *
 * @author cheji
 */
public class Proyecto_Final {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        Mapa mapa = new Mapa(grafo);
        System.out.println("Hello World!");
        Lectura_Archivos.leerArchivo(grafo);
        mapa.setLocationRelativeTo(null);
        mapa.setVisible(true);
        grafo.elegir();
        
        grafo.graficar_Auto();
        //grafo.graficar_Caminando();
        
    }
}
