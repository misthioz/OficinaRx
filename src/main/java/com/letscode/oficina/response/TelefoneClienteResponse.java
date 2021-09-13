package com.letscode.oficina.response;

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

}
