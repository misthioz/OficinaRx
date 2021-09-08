package com.letscode.oficina.response;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

public class ClienteResponse {

    private String nome;
    private LocalDate dataNascimento;
    private String enderecoComplemento;
    private String enderecoNumero;
    private Endereco endereco;


}
