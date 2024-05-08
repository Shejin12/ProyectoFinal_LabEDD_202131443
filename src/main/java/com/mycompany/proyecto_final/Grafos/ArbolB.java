package main.java.com.mycompany.proyecto_final.Grafos;

import java.io.FileWriter;
import java.io.IOException;

public class ArbolB {
    private NodoB raiz;

    public ArbolB() {
        raiz = new NodoB();
    }

    public void insertar(String clave) {
        NodoB r = raiz;
        if (r.n == 5) { // Si la raíz está llena
            NodoB s = new NodoB();
            raiz = s;
            s.hoja = false;
            s.n = 0;
            s.hijos.add(r);
            dividirNodo(s, 0, r);
            insertarEnNodoNoLleno(s, clave);
        } else {
            insertarEnNodoNoLleno(r, clave);
        }
    }

private void insertarEnNodoNoLleno(NodoB nodo, String clave) {
    int i = nodo.n - 1;
    if (nodo.hoja) {
        while (i >= 0 && clave.compareTo(nodo.claves.get(i)) < 0) {
            nodo.claves.set(i + 1, nodo.claves.get(i));
            i--;
        }
        nodo.claves.add(i + 1, clave); // Ajuste para evitar el índice fuera de los límites
        nodo.n++;
    } else {
        while (i >= 0 && clave.compareTo(nodo.claves.get(i)) < 0) {
            i--;
        }
        i++;
        NodoB hijo = nodo.hijos.get(i);
        if (hijo.n == 5) {
            dividirNodo(nodo, i, hijo);
            if (clave.compareTo(nodo.claves.get(i)) > 0) {
                i++;
            }
            // Verificar si i está dentro de los límites del array de hijos
            if (i < nodo.hijos.size()) {
                insertarEnNodoNoLleno(nodo.hijos.get(i), clave);
            } else {
                // Si i está fuera de los límites, se debe insertar en el último hijo
                NodoB nuevoHijo = new NodoB();
                nodo.hijos.add(nuevoHijo);
                insertarEnNodoNoLleno(nuevoHijo, clave);
            }
        } else {
            insertarEnNodoNoLleno(nodo.hijos.get(i), clave);
        }
    }
}


    private void dividirNodo(NodoB padre, int indice, NodoB nodo) {
        NodoB nuevoNodo = new NodoB();
        nuevoNodo.hoja = nodo.hoja;
        nuevoNodo.n = 2; // Dividir nodo en 2 partes
        for (int j = 0; j < 2; j++) {
            nuevoNodo.claves.add(j, nodo.claves.get(j + 3));
        }
        if (!nodo.hoja) {
            for (int j = 0; j < 3; j++) {
                nuevoNodo.hijos.add(j, nodo.hijos.get(j + 3));
            }
        }
        nodo.n = 2; // El nodo original se queda con 2 claves
        for (int j = padre.n; j > indice; j--) {
            padre.hijos.set(j + 1, padre.hijos.get(j));
        }
        padre.hijos.set(indice, nuevoNodo);
        for (int j = padre.n - 1; j >= indice; j--) {
            padre.claves.set(j + 1, padre.claves.get(j));
        }
        padre.claves.set(indice, nodo.claves.get(2));
        padre.n++;
    }

    public void imprimir() {
        imprimirRecursivo(raiz);
    }

    private void imprimirRecursivo(NodoB nodo) {
        for (int i = 0; i < nodo.n; i++) {
            System.out.print(nodo.claves.get(i) + " ");
        }
        if (!nodo.hoja) {
            for (int i = 0; i <= nodo.n; i++) {
                imprimirRecursivo(nodo.hijos.get(i));
            }
        }
    }

    public void generarDot(String nombreArchivo) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(nombreArchivo);
            fw.write("digraph ArbolB {\n");
            generarDotRecursivo(raiz, fw);
            fw.write("}\n");
            fw.close();
            graficar(nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void generarDotRecursivo(NodoB nodo, FileWriter fw) throws IOException {
        for (int i = 0; i < nodo.n; i++) {
            fw.write("\t" + nodo.claves.get(i) + ";\n");
        }
        if (!nodo.hoja) {
            for (int i = 0; i <= nodo.n; i++) {
                fw.write("\t" + nodo.claves.get(i) + " -> " + nodo.hijos.get(i).claves.get(0) + ";\n");
                generarDotRecursivo(nodo.hijos.get(i), fw);
            }
        }
    }
    private void graficar(String nombre){
        try {
            ProcessBuilder procesoBuilder = new ProcessBuilder("dot", "-Tpng", nombre, "-o", "ArbolB.png"); 
            procesoBuilder.inheritIO();

            Process proceso = procesoBuilder.start();
            proceso.waitFor();

            //System.out.println("Proceso completado");
        } catch (IOException | InterruptedException e) {
            System.err.println("Error al ejecutar el proceso: " + e.getMessage());
        }
    }
    
    /*public static void main(String[] args) {
        ArbolB arbolB = new ArbolB();
        arbolB.insertar("Hola");
        arbolB.insertar("Adiós");
        arbolB.insertar("OpenAI");
        arbolB.insertar("Inteligencia");
        arbolB.insertar("Artificial");
        arbolB.insertar("ChatGPT");
        arbolB.generarDot("arbolB.dot");
        arbolB.imprimir();
    }*/
}
