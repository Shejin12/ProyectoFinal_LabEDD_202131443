/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto_final;

import com.mycompany.proyecto_final.Estructura.Lectura_Archivos;
import com.mycompany.proyecto_final.Grafos.Grafo;

/**
 *
 * @author cheji
 */
public class Proyecto_Final {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();
        System.out.println("Hello World!");
        Lectura_Archivos.leerArchivo(grafo);
        //grafo.graficar_Auto();
        grafo.graficar_Caminando();
        
    }
}
