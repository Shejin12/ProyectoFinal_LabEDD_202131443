import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import main.java.com.mycompany.proyecto_final.Estructura.BTreeNode;

/*class BTree {
    private int t;
    private BTreeNode root;

    BTree(int t) {
        this.t = t;
        root = null;
    }

    void insert(String key) {
        if (root == null) {
            root = new BTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                BTreeNode s = new BTreeNode(t, false);
                s.C[0] = root;
                s.splitChild(0, root);
                int i = 0;
                if (s.keys[0].compareTo(key) < 0) {
                    i++;
                }
                s.C[i].insertNonFull(key);
                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    
    void generateDotFile(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write("digraph BTree {\n");
            if (root != null) {
                root.generateDotNode(writer);
            }
            writer.write("}\n");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/