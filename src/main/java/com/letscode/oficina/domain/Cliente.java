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
@Table("Cliente")
public class Cliente {

    @Id
    private String id;
    private String nome;
    @Column("data_nascimento")
    private LocalDate dataNascimento;
    private String cep;
    @Column("endereco_complemento")
    private String enderecoComplemento;
    @Column("endereco_numero")
    private String enderecoNumero;

}
