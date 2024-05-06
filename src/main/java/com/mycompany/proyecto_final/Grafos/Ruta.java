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
    
    public void imprimirRuta(){
        agregarDatosRuta();
        System.out.println(rutaString);
        System.out.println("distancia: " + distanciaTotal + "     tiempo: " + tiempoTotal + "     gasto: " + gastoTotal);
    }
    
    private void agregarDatosRuta(){
        Nodo actual;
        for (int i = 0; i < ruta.size()-1; i++) {
            actual = ruta.get(i);
            distanciaTotal += actual.getDistancia(ruta.get(i+1));
            tiempoTotal += actual.getTiempo(ruta.get(i+1), false);
            gastoTotal += actual.getDesgaste(ruta.get(i+1), false);
        }    
    }
    
    
}
