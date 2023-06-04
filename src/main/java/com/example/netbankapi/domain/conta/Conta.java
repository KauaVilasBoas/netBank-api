package com.example.netbankapi.domain.conta;

import com.example.netbankapi.domain.cliente.Cliente;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "contas")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
@MappedSuperclass

public abstract class Conta implements IConta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double saldo;
    private Integer numero;
    private Integer conta;
    @Embedded
    private Cliente cliente;


}
