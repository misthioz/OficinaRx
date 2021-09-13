package com.letscode.oficina.request;

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
