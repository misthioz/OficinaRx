package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Mecanico")
public class Mecanico {

    @Id
    private String id;
    private String nome;
    private String cep;
    @Column("endereco_complemento")
    private String enderecoComplemento;
    @Column("endereco_numero")
    private String enderecoNumero;
    @Column("id_Especialidade")
    private String idEspecialidade;

}

