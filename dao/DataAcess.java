package dao;

import java.io.*;
import model.*;

public class DataAcess {
    // Atributos de classe
    public static final int CODIGO_RENDIMENTO = 1;
    public static final int CODIGO_APORTE = 2;
    public static final int CODIGO_RETIRADA = 3;
    
    private static final String PATH = "files\\colecaoContas.obj";
    
    // Atributos de instância
    private ConjuntoContas colecaoContas;
    
    public DataAcess() {
        if (arquivoExistir()) {
            lerColecaoDeObjetos();
        } else {
            criarColecaoDeObjetos();
        }
    }
    
    public boolean armazenarConta(long id, Conta conta) {
        boolean result = colecaoContas.adicionar(id, conta);
        atualizarArquivo();
        return result;
    }
    
    public boolean removerConta(long id) {
        boolean result = colecaoContas.remover(id);
        atualizarArquivo();
        return result;
    }
    
    public boolean atualizarConta(long id, int tipoMovimentacao, float dadoRelevante) {
        boolean estadoArquivoModificado = false;
        if (colecaoContas.verificarID(id)) {
            estadoArquivoModificado = true;
            switch (tipoMovimentacao) {
                case 1 -> { // Rendimento
                    estadoArquivoModificado = estadoArquivoModificado && colecaoContas.selecionarConta(id).rendimento(dadoRelevante);
                }
                case 2 -> { // Aporte 
                    estadoArquivoModificado = estadoArquivoModificado && colecaoContas.selecionarConta(id).aporte(dadoRelevante);
                }
                case 3 -> { // Retirada
                    estadoArquivoModificado = estadoArquivoModificado && colecaoContas.selecionarConta(id).retirada(dadoRelevante);
                }
            }
        }
        return estadoArquivoModificado;
    }
    
    private boolean arquivoExistir() {
        boolean existe = true;
        try {
            FileInputStream in = new FileInputStream(PATH);
            in.close();
        } catch (FileNotFoundException fnfe) {
            existe = false;
        } catch(IOException ioe) {}
        return existe;
    }
    
    private boolean lerColecaoDeObjetos() {
        boolean objLido = false;
        try {
            colecaoContas = (ConjuntoContas) new ObjectInputStream(new FileInputStream(PATH)).readObject();
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
            new ObjectOutputStream(new FileOutputStream(PATH)).writeObject(colecaoContas);
        } 
        catch (FileNotFoundException fnfe) {} 
        catch (IOException io) {}
    }
}
