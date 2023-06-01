package com.example.netbankapi.controller;

import com.example.netbankapi.domain.conta.contaCorrente.*;
import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("contas")
public class ContaController {

    @Autowired
    private ContaCorrenteRepository contaCorrenteRepository;

    @PostMapping("/novaConta")
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroContaCorrente dados){
        var conta = new ContaCorrente(dados);

        contaCorrenteRepository.save(conta);

        return ResponseEntity.ok().build();

    }

    @PutMapping("/deposito")
    @Transactional
    public ResponseEntity deposito(@RequestBody @Valid DadosDeposito dados){

        var conta = contaCorrenteRepository.getReferenceById(dados.id());

        conta.deposita(dados);

        return ResponseEntity.ok("Deposito efetuado com sucesso - " + LocalDateTime.now());
    }

    @PutMapping("/saque")
    @Transactional
    public ResponseEntity saque(@RequestBody @Valid DadosSaque dados) throws SaldoInsuficiente {

        var conta = contaCorrenteRepository.getReferenceById(dados.id());

        conta.saque(dados);

        return ResponseEntity.ok("Saque efetuado com sucesso! - " + LocalDateTime.now());

    }

}
