package com.mycompany.proyecto_final.Nodos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Nodo {
    private String nombre;
    private LinkedList<Nodo> adyacentes = new LinkedList<>();
    private LinkedList<Nodo> adyacentes_Caminando = new LinkedList<>();
    Map<String, Integer> distancias = new HashMap<>();
    Map<String, Integer> gasto_combustible = new HashMap<>();
    Map<String, Integer> gasto_a_pie = new HashMap<>();
    Map<String, Integer> tiempo_auto = new HashMap<>();
    Map<String, Integer> tiempo_caminar = new HashMap<>();
    
    public Nodo(String name){
        nombre=name;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void ingresarDatos(Nodo adyacente, int distancia, int combustible, int cansansio, int tiempoA, int tiempoC){
        adyacentes.add(adyacente);
        distancias.put(adyacente.getNombre(), distancia);
        gasto_combustible.put(adyacente.getNombre(), combustible);
        gasto_a_pie.put(adyacente.getNombre(), cansansio);
        tiempo_auto.put(adyacente.getNombre(), tiempoA);
        tiempo_caminar.put(adyacente.getNombre(), tiempoC);
    }

    public void ingresarAdyacenteCaminando(Nodo caminando, int distancia, int cansansio, int tiempoC){
        adyacentes_Caminando.add(caminando);
        distancias.put(caminando.getNombre(), distancia);
        gasto_a_pie.put(caminando.getNombre(), cansansio);
        tiempo_caminar.put(caminando.getNombre(), tiempoC);
    }
    
    public void muestraAdyacen(){
        for (Nodo adyacente : adyacentes) {
            System.out.println("        " + adyacente.getNombre());
        }
    }
    
    public LinkedList<Nodo> getAdyacentes(){
        return adyacentes;
    }
    
    public LinkedList<Nodo> getCaminando(){
        return adyacentes_Caminando;
    }
}
