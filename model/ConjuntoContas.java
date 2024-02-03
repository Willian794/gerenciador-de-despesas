package model;

import java.util.HashMap;

public class ConjuntoContas {
    private HashMap<String, Conta> contas;
    
    public ConjuntoContas() {
        contas = new HashMap();
    }
    
    public void adicionar(String chave, Conta conta) {
        contas.put(chave, conta);
    }
    
    public void deletar(String chave) {
        contas.remove(chave);
    }
}
