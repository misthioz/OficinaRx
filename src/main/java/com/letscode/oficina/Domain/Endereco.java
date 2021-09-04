package com.letscode.oficina.Domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Endereco {

    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

}
