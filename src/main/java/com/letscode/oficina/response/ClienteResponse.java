package com.letscode.oficina.response;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private String nome;
    private LocalDate dataNascimento;
    private String enderecoComplemento;
    private String enderecoNumero;
    private Endereco endereco;

    public ClienteResponse(Endereco endereco) {
        this.endereco = endereco;
    }
}
