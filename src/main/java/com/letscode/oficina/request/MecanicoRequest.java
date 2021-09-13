package com.letscode.oficina.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
