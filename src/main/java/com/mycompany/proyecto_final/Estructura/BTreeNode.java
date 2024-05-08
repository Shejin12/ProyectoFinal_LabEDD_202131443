package main.java.com.mycompany.proyecto_final.Estructura;


import java.io.BufferedWriter;
import java.io.IOException;

public class BTreeNode {
        public int[] n; 
        public String[] keys; 
        public BTreeNode[] C;
        public boolean leaf;
        public int t;

        public BTreeNode(int t, boolean leaf) {
            this.t = t;
            this.leaf = leaf;
            n = new int[2 * t - 1];
            keys = new String[2 * t - 1];
            C = new BTreeNode[2 * t];
        }

        // Método para insertar una clave en un nodo que no está lleno
        public void insertNonFull(String key) {
            int i = n[0];
            if (leaf) {
                while (i >= 1 && key.compareTo(keys[i - 1]) < 0) {
                    keys[i] = keys[i - 1];
                    i--;
                }
                keys[i] = key;
                n[0]++;
            } else {
                while (i >= 1 && key.compareTo(keys[i - 1]) < 0) {
                    i--;
                }
                if (C[i].n[0] == 2 * t - 1) {
                    splitChild(i, C[i]);
                    if (key.compareTo(keys[i]) > 0) {
                        i++;
                    }
                }
                C[i].insertNonFull(key);
            }
        }

        public void splitChild(int i, BTreeNode y) {
            BTreeNode z = new BTreeNode(y.t, y.leaf);
            z.n[0] = t - 1;
            for (int j = 0; j < t - 1; j++) {
                z.keys[j] = y.keys[j + t];
            }
            if (!y.leaf) {
                for (int j = 0; j < t; j++) {
                    z.C[j] = y.C[j + t];
                }
            }
            y.n[0] = t - 1;
            for (int j = n[0]; j >= i + 1; j--) {
                C[j + 1] = C[j];
            }
            C[i + 1] = z;
            for (int j = n[0] - 1; j >= i; j--) {
                keys[j + 1] = keys[j];
            }
            keys[i] = y.keys[t - 1];
            n[0]++;
        }

        
    public void generateDotNode(BufferedWriter writer) throws IOException {
        for (int i = 0; i < n[0]; i++) {
            writer.write("\t\"" + this.hashCode() + "-" + i + "\" [label=\"" + keys[i] + "\"];\n");
        }
        if (!leaf) {
            for (int i = 0; i <= n[0]; i++) {
                if (C[i] != null) {
                    C[i].generateDotNode(writer);
                    writer.write("\t\"" + this.hashCode() + "-" + i + "\" -> \"" + C[i].hashCode() + "\";\n");
                }
            }
        }
    }
    
}