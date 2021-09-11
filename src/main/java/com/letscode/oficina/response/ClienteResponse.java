package com.letscode.oficina.response;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import lombok.Data;
import lombok.Getter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
public class ClienteResponse {

    private String id;
    private String nome;
    private LocalDate dataNascimento;
    private String enderecoComplemento;
    private String enderecoNumero;
    private Endereco endereco;
    private List<TelefoneClienteResponseMinimal> telefones;

//    public ClienteResponse(Endereco endereco, Cliente cliente) {
//        this.nome = cliente.getNome();
//        this.endereco = endereco;
//    }

    public static ClienteResponse convert (Cliente cliente){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setId(cliente.getId());


        return clienteResponse;
    }

}
