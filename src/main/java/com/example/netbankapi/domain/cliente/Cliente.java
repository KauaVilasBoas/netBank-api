package com.example.netbankapi.domain.cliente;

import com.example.netbankapi.domain.endereco.Endereco;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "cpf")
@Embeddable
public class Cliente {

    private String nome;
    private String sobrenome;
    private String cpf;
    @Embedded
    private Endereco endereco;

    public Cliente(DadosCadastroCliente dados){
        this.nome = dados.nome();
        this.sobrenome = dados.sobrenome();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

}
