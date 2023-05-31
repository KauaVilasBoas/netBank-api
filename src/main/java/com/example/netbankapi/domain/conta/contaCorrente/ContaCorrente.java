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

    public ContaCorrente (DadosCadastroContaCorrente dados){
        this.dataDeAbertura = LocalDateTime.now();
        this.setSaldo(dados.saldo());
        this.setConta(dados.conta());
        this.setNumero(dados.numero());
        this.setCliente(new Cliente(dados.cliente()));
    }

    @Override
    public String saque(Double valor) throws SaldoInsuficiente {

        if (valor > 0 && this.getSaldo() >= valor) {
            Double saque = valor + taxaDeSaque;
            this.setSaldo(this.getSaldo() - saque);
            return "Saque efetuado com sucesso! - " + LocalDateTime.now();
        } else {
            throw new SaldoInsuficiente("Erro ao sacar, verifique o seu saldo");
        }
    }

    @Override
    public String deposita(Double valor) {

        if (valor > 0) {
            this.setSaldo(this.getSaldo() + valor);
            return "Deposito efetuado! - " + LocalDateTime.now();
        }
        return null;
    }

    @Override
    public String transferencia(Double valor, Conta contaDestino) throws SaldoInsuficiente {
        if (valor > 0 && this.getSaldo() >= valor) {
            this.setSaldo(this.getSaldo() - valor);
            contaDestino.setSaldo(contaDestino.getSaldo() + valor);
            return "Transferência efetuada! - " + LocalDateTime.now();
        } else {
            throw new SaldoInsuficiente("Erro ao transferir, verifique o seu saldo");
        }
    }
}
