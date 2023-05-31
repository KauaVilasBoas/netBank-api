package com.example.netbankapi.domain.conta;

import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;

public interface IConta {

    public abstract String saque(Double valor) throws SaldoInsuficiente;
    public abstract String deposita(Double valor);
    public abstract String transferencia(Double valor, Conta contaDestino) throws SaldoInsuficiente;

}
