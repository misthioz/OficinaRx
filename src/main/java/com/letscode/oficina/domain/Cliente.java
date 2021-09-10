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
    @Column("id")
    private String id;
    @Column("nome")
    private String nome;
    @Column("dataNascimento")
    private LocalDate dataNascimento;
    @Column("cep")
    private String cep;
    @Column("enderecoComplemento")
    private String enderecoComplemento;
    @Column("enderecoNumero")
    private String enderecoNumero;


}
