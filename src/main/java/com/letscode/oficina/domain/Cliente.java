package com.letscode.oficina.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@ToString
@Table("CLIENTE")
public class Cliente {

    @Id
    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;


}
