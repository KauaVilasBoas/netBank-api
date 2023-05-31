package com.example.netbankapi.controller;

import com.example.netbankapi.domain.conta.contaCorrente.ContaCorrente;
import com.example.netbankapi.domain.conta.contaCorrente.ContaCorrenteRepository;
import com.example.netbankapi.domain.conta.contaCorrente.DadosCadastroContaCorrente;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
