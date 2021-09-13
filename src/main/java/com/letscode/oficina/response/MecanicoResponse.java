package com.letscode.oficina.response;

import com.letscode.oficina.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MecanicoResponse {

    private String id;
    private String nome;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;
    private Endereco endereco;
    private String idEspecialidade;
    private String especialidade;

}
