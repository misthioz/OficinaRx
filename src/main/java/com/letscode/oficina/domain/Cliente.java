package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@Document
@ToString

public class Cliente {

    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;


}
