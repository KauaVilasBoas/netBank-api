package com.example.netbankapi.infra.exception;

import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(SaldoInsuficiente.class)
    public ResponseEntity tratarErroSaldoInsuficiente(){
        return ResponseEntity.badRequest().build();
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity tratarDuplicidade(){return ResponseEntity.badRequest().body("Erro, duplicidade encontrada!");}

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity tratarEntidadeNaoEncontrada(){return ResponseEntity.badRequest().body("Conta inexistente, confira os dados");}

}
