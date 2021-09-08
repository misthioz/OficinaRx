package com.letscode.oficina.uteis;

import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.propertyeditors.ClassEditor;

public class Conversores {

    public static ClienteRequest clienteParaClienteRequest (Cliente cliente) {
        ClienteRequest clienteRequest = new ClienteRequest();
        BeanUtils.copyProperties(cliente, clienteRequest);
        return clienteRequest;
    }

    public static Cliente clienteRequestParaCliente (ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        return cliente;
    }

}

