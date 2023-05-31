package com.example.netbankapi.domain.endereco;

import jakarta.validation.constraints.NotBlank;

public record DadosEndereco(

        @NotBlank
        String rua,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        Integer numeroResidencial) {
}
