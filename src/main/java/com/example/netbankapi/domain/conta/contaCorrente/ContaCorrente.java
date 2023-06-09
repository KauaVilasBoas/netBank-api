package com.example.netbankapi.domain.conta.contaCorrente;

import com.example.netbankapi.domain.cliente.Cliente;
import com.example.netbankapi.domain.conta.Conta;
import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Entity(name = "ContaCorrente")

public class ContaCorrente extends Conta {

    private Double taxaDeSaque = 5.0;
    private LocalDateTime dataDeAbertura;

    public ContaCorrente(DadosCadastroContaCorrente dados) {
        this.dataDeAbertura = LocalDateTime.now();
        this.setSaldo((double) 0);
        this.setConta(dados.conta());
        this.setNumero(dados.numero());
        this.setCliente(new Cliente(dados.cliente()));
    }

    @Override
    public void saque(DadosSaque dadosSaque) throws SaldoInsuficiente {

        if (dadosSaque.valor() > 0 && this.getSaldo() >= dadosSaque.valor()) {
            Double saque = dadosSaque.valor() + taxaDeSaque;
            this.setSaldo(this.getSaldo() - saque);
        } else {
            throw new SaldoInsuficiente("Erro ao sacar, verifique o seu saldo");
        }
    }

    @Override
    public void deposita(DadosDeposito dadosDeposito) throws RuntimeException {

        if (dadosDeposito.valor() != null) {
            if (dadosDeposito.valor() > 0) {
                this.setSaldo(this.getSaldo() + dadosDeposito.valor());
            } else {
                throw new RuntimeException();
            }
        }
    }

    @Override
    public void transferencia(Double valor, Conta contaDestino) throws SaldoInsuficiente {

        if (valor > 0 && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
        } else {
            throw new SaldoInsuficiente("Erro ao transferir, verifique o seu saldo");
        }

    }
}
