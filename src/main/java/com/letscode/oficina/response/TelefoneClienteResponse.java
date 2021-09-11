package com.letscode.oficina.response;

import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import com.letscode.oficina.domain.TelefoneCliente;
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
public class TelefoneClienteResponse {

    private String idTelefone;
    private String telefone;
    private String idCliente;
    private String clienteNome;
    private Cliente cliente;

    public TelefoneClienteResponse (TelefoneCliente telefoneCliente, Cliente cliente){
        this.idTelefone = telefoneCliente.getTelefone();
        this.telefone = telefoneCliente.getTelefone();
        this.cliente = cliente;
    }


}
