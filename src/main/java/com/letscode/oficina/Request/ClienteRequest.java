package com.letscode.oficina.Request;

import com.letscode.oficina.domain.Cliente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteRequest {

    private String nome;
    private LocalDate dataNascimento;
    private String cep;
    private String enderecoComplemento;
    private String enderecoNumero;

    public Cliente convert() {

        Cliente cliente = new Cliente();

        cliente.setNome(this.nome);
        cliente.setDataNascimento(this.dataNascimento);
        cliente.setCep(this.cep);
        cliente.setEnderecoComplemento(this.enderecoComplemento);
        cliente.setEnderecoNumero(this.enderecoNumero);

        return cliente;
    }

}
