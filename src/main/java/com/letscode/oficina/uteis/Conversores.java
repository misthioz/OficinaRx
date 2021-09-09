package com.letscode.oficina.uteis;

import com.letscode.oficina.Request.CarroRequest;
import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.ClienteResponse;
import org.springframework.beans.BeanUtils;


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

    public static Carro carroRequestParaCarro(CarroRequest carroRequest){
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroRequest,carro);
        return carro;
    }

    public static TelefoneCliente telefoneClienteRequestParaTelefoneCliente (TelefoneClienteRequest telefoneClienteRequest) {
        TelefoneCliente telefoneCliente = new TelefoneCliente();
        BeanUtils.copyProperties(telefoneClienteRequest, telefoneCliente);
        return telefoneCliente;
    }

    public static ClienteResponse clienteParaClienteResponse (Cliente cliente) {

        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setDataNascimento(cliente.getDataNascimento());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setEnderecoComplemento(cliente.getEnderecoComplemento());
        clienteResponse.setEnderecoNumero(cliente.getEnderecoNumero());
        return clienteResponse;


    }


}

