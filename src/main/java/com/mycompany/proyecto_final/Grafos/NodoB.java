package main.java.com.mycompany.proyecto_final.Grafos;

import java.util.ArrayList;

class NodoB {
    int n; // Número actual de claves en el nodo
    ArrayList<String> claves;
    ArrayList<NodoB> hijos;
    boolean hoja;

    public NodoB() {
        this.n = 0;
        this.claves = new ArrayList<>();
        this.hijos = new ArrayList<>();
        this.hoja = true;
    }
}
