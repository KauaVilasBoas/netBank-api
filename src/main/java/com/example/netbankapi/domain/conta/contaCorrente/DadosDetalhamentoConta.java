package com.example.netbankapi.domain.conta.contaCorrente;

import com.example.netbankapi.domain.cliente.DadosCadastroCliente;

public record DadosDetalhamentoConta(String nomeCliente, String email, String cpf, Integer numero, Integer conta) {
}
