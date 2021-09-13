package com.letscode.oficina.response;

import com.letscode.oficina.domain.Endereco;
import lombok.Data;
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

}
