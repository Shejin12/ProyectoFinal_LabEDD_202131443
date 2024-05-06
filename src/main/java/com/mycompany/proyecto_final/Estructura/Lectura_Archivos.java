package main.java.com.mycompany.proyecto_final.Estructura;

import main.java.com.mycompany.proyecto_final.Nodos.Nodo;
import main.java.com.mycompany.proyecto_final.Grafos.Grafo;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Lectura_Archivos {
    
        public static void leerArchivo(Grafo grafo){
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);
        File archivoSeleccionado = fileChooser.getSelectedFile();
       

        try {
            BufferedReader buffer = new BufferedReader(new FileReader(archivoSeleccionado.getAbsolutePath()));
            String linea;
            while ((linea = buffer.readLine()) != null) {
                String datos[] = linea.split("\\|");
                Nodo nuevo = new Nodo(datos[0]);
                Nodo nuevo2 = new Nodo(datos[1]);
                
                /*
                for (String dato : datos) {
                    System.out.println(dato);
                }
                */
                
                grafo.agregarNodo(nuevo);
                grafo.agregarNodo(nuevo2);
                int dist = Integer.parseInt(datos[6]);
                int gaso = Integer.parseInt(datos[4]);
                int cans = Integer.parseInt(datos[5]);
                int tmpA = Integer.parseInt(datos[2]);
                int tmpC = Integer.parseInt(datos[3]);
                grafo.conectarNodos(datos[0], datos[1], dist, gaso, cans, tmpA, tmpC);
                
                linea = "";
            }
            buffer.close();

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
        
   
    
    
    
   
}
