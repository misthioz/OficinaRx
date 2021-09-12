package com.letscode.oficina.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Column;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoRequest {

    private Integer id;
    private String nome;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;
    private String idEspecialidade;
}
