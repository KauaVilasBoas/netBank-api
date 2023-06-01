package com.example.netbankapi.domain.conta.contaCorrente;

import jakarta.validation.constraints.NotNull;

public record DadosDeposito(

        @NotNull
        Long id,
        @NotNull
        Double valor

) {
}
