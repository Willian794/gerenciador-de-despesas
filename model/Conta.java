package model;

import java.util.Calendar;

public class Conta {
    private String tipoConta;
    private Calendar abertura;
    private float saldo;
    
    public Conta() {
        this.tipoConta = "Conta Indefinida";
        this.saldo = 0;
        this.abertura = Calendar.getInstance();
    }
    
    public Conta(String tipoConta, Calendar abertura, float saldo) {
        this.tipoConta = tipoConta;
        this.saldo = saldo;
        this.abertura = abertura;
    }
    
    public boolean rendimento(float percentual) {
        boolean saldoAlterado = false;
        if (percentual > 0) {
            percentual /= 100;
            saldo *= (1 + percentual);
            saldoAlterado = true;
        }
        return saldoAlterado;
    }
    
    public boolean retirada(float valor) {
        boolean saldoAlterado = false;
        if(valor > 0) {
            saldo -= valor;
            saldoAlterado = true;
        }
        return saldoAlterado;
    }
}
