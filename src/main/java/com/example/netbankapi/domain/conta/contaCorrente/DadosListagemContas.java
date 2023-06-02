package com.example.netbankapi.domain.conta.contaCorrente;

import com.example.netbankapi.domain.cliente.Cliente;

public record DadosListagemContas(Long id, Double saldo, Integer numero, Integer conta, Cliente cliente) {

    public DadosListagemContas(ContaCorrente conta){

        this(conta.getId(), conta.getSaldo(), conta.getNumero(), conta.getConta(), conta.getCliente());

    }

}
