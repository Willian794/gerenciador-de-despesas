package businessService;

import model.*;
import dao.DataAcess;

public class BusinessServiceImpl {
    private DataAcess dao;
    
    public boolean inserirConta(long id, Conta conta) {
        return dao.armazenarConta(id, conta);
    }
    
    public boolean apagarConta(long id) {
        return dao.removerConta(id);
    }
    
    public boolean aporte(long id, float valor) {
        return dao.atualizarConta(id, DataAcess.CODIGO_APORTE, valor);
    }
    
    public boolean saque(long id, float valor) {
        return dao.atualizarConta(id, DataAcess.CODIGO_RETIRADA, valor);
    }
    
    public boolean rendimento(long id, float percentual) {
        return dao.atualizarConta(id, DataAcess.CODIGO_RENDIMENTO, percentual);
    }
}
