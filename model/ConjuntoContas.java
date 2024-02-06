package model;

import java.util.HashMap;

public class ConjuntoContas implements java.io.Serializable {
    private HashMap<Long, Conta> contas;
    
    public ConjuntoContas() {
        contas = new HashMap();
    }
    
    public boolean adicionar(long id, Conta conta) {
        boolean precisaAdicionar = !verificarID(id);
        if (precisaAdicionar) { // Se TRUE é porque a chave já está inserida no HashMap
            contas.put(id, conta);
        }
        return precisaAdicionar;
    }
    
    public boolean deletar(long id) {
        boolean contido = verificarID(id);
        if (contido) {
            contas.remove(id);
        }
        return contido;
    }
    
    private boolean verificarID(long id) {
        return contas.containsKey(id);
    }
}
