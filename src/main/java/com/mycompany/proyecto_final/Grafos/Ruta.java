package main.java.com.mycompany.proyecto_final.Grafos;

import java.util.LinkedList;
import main.java.com.mycompany.proyecto_final.Nodos.Nodo;

public class Ruta {
    
    private LinkedList<Nodo> ruta; 
    private String rutaString = ""; 
    private int distanciaTotal = 0;
    private int tiempoTotal = 0;
    private int gastoTotal = 0;
    
    
    public Ruta(LinkedList<Nodo> ruta){
        this.ruta = new LinkedList<>();
        //Copiar la ruta
        for (Nodo nodo : ruta) {
            this.ruta.add(nodo);
        }
    }
    
    public Ruta(){
        ruta = new LinkedList<>();
    }
    
    public boolean yaEnlistado(Nodo nodo){
        for (Nodo nodo1 : ruta) {
            rutaString += nodo1.getNombre()+" ";
            if(nodo1 == nodo){
                return true;
            }
        }
        ruta.add(nodo);
        rutaString += nodo.getNombre()+" ";
        return false; 
    }
    
    public void imprimirRuta(Grafo grafo, boolean caminar){
        agregarDatosRuta(caminar);
        grafo.colocarDatos(distanciaTotal, tiempoTotal, gastoTotal);
    }
    
    private void agregarDatosRuta(boolean caminar){
        Nodo actual;
        distanciaTotal = 0;
        tiempoTotal = 0;
        gastoTotal = 0;
        for (int i = 0; i < ruta.size()-1; i++) {
            actual = ruta.get(i);
            distanciaTotal += actual.getDistancia(ruta.get(i+1));
            tiempoTotal += actual.getTiempo(ruta.get(i+1), caminar);
            gastoTotal += actual.getDesgaste(ruta.get(i+1), caminar);
        }    
    }
    
    
}
