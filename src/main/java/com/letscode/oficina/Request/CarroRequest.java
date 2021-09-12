package com.letscode.oficina.Request;

import com.letscode.oficina.domain.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarroRequest {

    private String id;
    private String placa;
    private String marca;
    private String cor;
    private String idCliente;
}
