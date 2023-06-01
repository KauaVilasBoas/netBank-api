package com.example.netbankapi.domain.conta;

import com.example.netbankapi.domain.conta.contaCorrente.DadosDeposito;
import com.example.netbankapi.domain.conta.contaCorrente.DadosSaque;
import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;

public interface IConta {

    public abstract void saque(DadosSaque dadosSaque) throws SaldoInsuficiente;
    public abstract void deposita(DadosDeposito dadosDeposito);
    public abstract void transferencia(Double valor, Conta contaDestino) throws SaldoInsuficiente;

}
