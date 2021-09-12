package com.letscode.oficina.Request;

import com.letscode.oficina.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TelefoneClienteRequest {

    private String id;
    private String telefone;
    private String idCliente;

}
