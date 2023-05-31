package com.example.netbankapi.domain.conta.contaCorrente;

import com.example.netbankapi.domain.conta.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaCorrenteRepository extends JpaRepository<Conta, Long> {
}
