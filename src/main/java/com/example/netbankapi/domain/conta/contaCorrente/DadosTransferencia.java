package com.example.netbankapi.domain.conta.contaCorrente;

import jakarta.validation.constraints.NotNull;

public record DadosTransferencia(

        @NotNull
        Long idContaRemetente,
        @NotNull
        Double valor,
        @NotNull
        Long idContaDestino

) {
}
