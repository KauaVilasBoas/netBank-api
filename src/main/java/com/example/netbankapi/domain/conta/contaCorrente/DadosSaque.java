package com.example.netbankapi.domain.conta.contaCorrente;

import jakarta.validation.constraints.NotNull;

public record DadosSaque(

        @NotNull
        Long id,
        @NotNull
        Double valor

) {
}
