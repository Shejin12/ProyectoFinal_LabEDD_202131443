package main.java.com.mycompany.proyecto_final.Nodos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import main.java.com.mycompany.proyecto_final.Grafos.Ruta;

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
    
    /*public String Buscar(){
    return "";
    }*/
    
    public void buscarNodo(String destino, LinkedList<Ruta> rutas, LinkedList<Nodo> pasados){
        
        Ruta rt = new Ruta(pasados);
        if(! rt.yaEnlistado(this)){
            if(nombre.equals(destino)){
                rutas.add(rt);
            }else{
                //Seguir buscando
                LinkedList<Nodo> nuevosPasados = new LinkedList <>();
                for (Nodo pasado : pasados) {
                    nuevosPasados.add(pasado);
                }
                nuevosPasados.add(this);
                
                for (Nodo adyacente : adyacentes) {
                    adyacente.buscarNodo(destino, rutas, nuevosPasados);
                }
            }
        }
        
    }
    
    public int getDistancia(Nodo destino){
        if (destino != null)  {
            return distancias.get(destino.getNombre());
        }
        return 0;
    }
    
    public int getTiempo(Nodo destino, boolean caminando){
        if (destino != null) {
            if (caminando) {
                return tiempo_caminar.get(destino.getNombre());
            } else {
                return tiempo_auto.get(destino.getNombre());
            }
        }
        return 0;
    }
    
    public int getDesgaste(Nodo destino, boolean caminando){
        if (destino != null) {
            if (caminando) {
                return gasto_a_pie.get(destino.getNombre());
            } else {
                return gasto_combustible.get(destino.getNombre());
            }
        }
        return 0;
    }
    
}
