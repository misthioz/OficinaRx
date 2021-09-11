package com.letscode.oficina.transferobject.response;

import com.letscode.oficina.domain.TelefoneCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneClienteResponse {

    private String idTelefone;
    private String telefone;
    private String idCliente;
    private String clienteNome;

    public static TelefoneClienteResponse from(TelefoneCliente telefoneCliente){
        TelefoneClienteResponse telefoneClienteResponse = new TelefoneClienteResponse();
        telefoneClienteResponse.setIdTelefone(telefoneCliente.getId());
        telefoneClienteResponse.setTelefone(telefoneCliente.getTelefone());
        telefoneClienteResponse.setIdCliente(telefoneCliente.getIdCliente());
        return telefoneClienteResponse;
    }

}
