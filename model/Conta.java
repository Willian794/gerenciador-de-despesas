package model;

import java.util.Calendar;

public class Conta implements java.io.Serializable {
    // Atributo de classe
    private static long nContas = 0;
    
    // Atributos de instância
    private String nomeConta;
    private long id;
    private Calendar abertura;
    private float saldo;
    
    public Conta() {
        this.nomeConta = "Conta Indefinida";
        this.id = nContas++;
        this.abertura = Calendar.getInstance();
        this.saldo = 0;
    }
    
    public Conta(String nomeConta, long id, Calendar abertura, float saldo) {
        this.nomeConta = nomeConta;
        this.id = id;
        this.saldo = saldo;
        this.abertura = abertura;
        nContas++;
    }
    
    public String getNome() {
        return nomeConta;
    }
    
    public long getID() {
        return id;
    }
    
    public Calendar getAbertura() {
        return abertura;
    }
    
    public float getSaldo() {
        return saldo;
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
    
    public boolean aporte(float valor) {
        boolean saldoAlterado = false;
        if (valor > 0) {
            saldo += valor;
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
