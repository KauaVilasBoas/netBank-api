package com.example.netbankapi.infra.exception;

import com.example.netbankapi.domain.exceptions.SaldoInsuficiente;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(SaldoInsuficiente.class)
    public ResponseEntity tratarErroSaldoInsuficiente(){
        return ResponseEntity.badRequest().build();
    }

}
