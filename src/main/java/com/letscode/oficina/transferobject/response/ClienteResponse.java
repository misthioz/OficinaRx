package com.letscode.oficina.transferobject.response;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponse {

    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoComplemento;
    private String enderecoNumero;
    private Endereco endereco;
    private List<TelefoneClienteResponse> telefones;

    public ClienteResponse(Endereco endereco) {
        this.endereco = endereco;
    }

    public static ClienteResponse from(Cliente cliente){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setNome(cliente.getNome());
        return clienteResponse;
    }

}
