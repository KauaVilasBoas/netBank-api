package com.example.netbankapi.domain.conta.contaCorrente;

import com.example.netbankapi.domain.cliente.DadosCadastroCliente;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroContaCorrente(

        @NotNull
        Double saldo,
        @NotNull
        Integer numero,
        @NotNull
        Integer conta,

        @NotNull
        @Valid
        DadosCadastroCliente cliente) {
}
