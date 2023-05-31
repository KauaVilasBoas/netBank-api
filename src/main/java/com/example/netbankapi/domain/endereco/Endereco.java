package com.example.netbankapi.domain.endereco;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class Endereco {

    private String rua;
    private String bairro;
    private String cidade;
    private Integer numeroResidencial;

    public Endereco(DadosEndereco dados) {
        this.rua = dados.rua();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.numeroResidencial = dados.numeroResidencial();
    }

}
