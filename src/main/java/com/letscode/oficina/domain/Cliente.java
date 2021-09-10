package com.letscode.oficina.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Document

public class Cliente {

    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;

    private List<Carro> carros;
    private List<TelefoneCliente> telefones;

}
