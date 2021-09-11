package com.letscode.oficina.transferobject.request;

import com.letscode.oficina.domain.Especialidade;
import lombok.Data;

import java.util.List;

@Data
public class MecanicoRequest {

    private String nome;
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;

    private List<Especialidade> especialidades;

}