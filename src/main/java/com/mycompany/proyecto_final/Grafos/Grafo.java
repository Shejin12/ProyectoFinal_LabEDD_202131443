package main.java.com.mycompany.proyecto_final.Grafos;

import main.java.com.mycompany.proyecto_final.Nodos.Nodo;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Grafo {
    LinkedList<Nodo> nodos = new LinkedList<>();
    LinkedList<Ruta> ruta;
    
    
    
    public void agregarNodo(Nodo nuevo){
        Nodo resultado = findNodo(nuevo.getNombre());
        if (resultado == null) {
            nodos.add(nuevo);
        }
    }
    
    public void conectarNodos(String inicio, String destino, int dist, int gas, int cans, int timeA, int timeC){
        Nodo start = findNodo(inicio);
        if (start != null) {
            Nodo siguiente = findNodo(destino);
            if (siguiente != null) {
                start.ingresarDatos(siguiente, dist, gas, cans, timeA, timeC);
                siguiente.ingresarAdyacenteCaminando(start, dist, cans, timeC);
            }
        }
    }
    
    public void datos(){
        for (Nodo nodo : nodos) {
            System.out.println(nodo.getNombre());
            nodo.muestraAdyacen();
        }
    }
    
    public Nodo findNodo(String nombre){
        for (Nodo nodo : nodos) {
            if (nodo.getNombre().equals(nombre)) {
               return nodo;
            }
        }
        return null;
    }
    
    public void graficar_Auto(){
        String codigoG = "digraph G{\n";
        
        for (Nodo nodo : nodos) {
            if(nodo != null){
                LinkedList<Nodo> ady = nodo.getAdyacentes();
                for (Nodo nodo1 : ady) {
                    if(nodo1 != null){
                        codigoG += nodo.getNombre()+ " -> " + nodo1.getNombre() + ";\n";
                    }
                }
            }
        }
        
        codigoG += "}";
        guardar(codigoG);
        graficar();
    }
    
    private void guardar(String texto){
        //System.out.println(texto);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("./Grafo.dot"))) {
            writer.write(texto);
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
    
    private void graficar(){
        try {
            ProcessBuilder procesoBuilder = new ProcessBuilder("dot", "-Tpng", "./Grafo.dot", "-o", "Grago.png"); 
            procesoBuilder.inheritIO();

            Process proceso = procesoBuilder.start();
            proceso.waitFor();

            System.out.println("Proceso completado");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }

    public void graficar_Caminando(){
        String codigoG = "digraph G{\n";
        
        for (Nodo nodo : nodos) {
            if(nodo != null){
                
                LinkedList<Nodo> cam = nodo.getCaminando();
                for (Nodo nodo1 : cam) {
                    if(nodo1 != null){
                        codigoG += nodo.getNombre()+ " -> " + nodo1.getNombre() + ";\n";
                    }
                }
                
                LinkedList<Nodo> ady = nodo.getAdyacentes();
                for (Nodo nodo1 : ady) {
                    if(nodo1 != null){
                        codigoG += nodo.getNombre()+ " -> " + nodo1.getNombre() + ";\n";
                    }
                }
                
                
            }
        }
        
        codigoG += "}";
        guardar(codigoG);
        graficar();
    }
    
    public void elegir(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1");
        String origen = scanner.nextLine();
        System.out.println("2");
        String destino = scanner.nextLine();
        busquedaRuta(origen, destino);
    }
    
    public void busquedaRuta(String origen, String destino){
        
        Nodo start = findNodo(origen);
        if (start != null) {
            ruta = new LinkedList<>();
            LinkedList<Nodo> pasados = new LinkedList<>();
            start.buscarNodo(destino, ruta, pasados);
        }
        for (Ruta nodo : ruta) {
            nodo.imprimirRuta();
        }
    }
    
    public LinkedList<Ruta> getRuta(){
        return ruta;
    }
    
    public LinkedList<Nodo> getNodos(){
        return nodos;
    }
    
    
    
}
