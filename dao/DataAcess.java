package dao;

import java.io.*;
import model.ConjuntoContas;

public class DataAcess {
    // Atributos de classe
    private final String path = "files\\colecaoContas.obj";
    
    // Atributos de instância
    private ConjuntoContas colecaoContas;
    
    public DataAcess() {
        if (arquivoExistir()) {
            lerColecaoDeObjetos();
        } else {
            criarColecaoDeObjetos();
        }
    }
    
    private boolean arquivoExistir() {
        boolean existe = true;
        try {
            FileInputStream in = new FileInputStream(path);
        } catch (FileNotFoundException fnfe) {
            existe = false;
        }
        return existe;
    }
    
    private boolean lerColecaoDeObjetos() {
        boolean objLido = false;
        try {
            colecaoContas = (ConjuntoContas) new ObjectInputStream(new FileInputStream(path)).readObject();
            objLido = true;
        } catch (ClassNotFoundException | IOException fe) {}
        return objLido;
    }
    
    private void criarColecaoDeObjetos() {
        colecaoContas = new ConjuntoContas();
        atualizarArquivo();
    }
    
    private void atualizarArquivo() {
        try {
            new ObjectOutputStream(new FileOutputStream(path)).writeObject(colecaoContas);
        } 
        catch (FileNotFoundException fnfe) {} 
        catch (IOException io) {}
    }
}
