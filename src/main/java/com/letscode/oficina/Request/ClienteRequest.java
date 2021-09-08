package com.letscode.oficina.Request;

import com.letscode.oficina.domain.Cliente;
import lombok.*;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequest {

    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;

}
