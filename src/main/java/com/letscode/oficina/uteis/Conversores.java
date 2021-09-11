package com.letscode.oficina.uteis;

import com.letscode.oficina.Request.CarroRequest;
import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.ClienteResponse;
import com.letscode.oficina.response.TelefoneClienteResponse;
import com.letscode.oficina.service.ClienteService;
import com.letscode.oficina.service.EnderecoService;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.Optional;

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

    public static TelefoneClienteResponse telefoneClienteParaTelefoneClienteResponse (TelefoneCliente telefoneCliente) {
        TelefoneClienteResponse telefoneClienteResponse = new TelefoneClienteResponse();
        telefoneClienteResponse.setTelefone(telefoneCliente.getTelefone());
        telefoneClienteResponse.setIdCliente(telefoneCliente.getIdcliente());
        telefoneClienteResponse.setIdTelefone(telefoneCliente.getId());
        return  telefoneClienteResponse;
    }

    public static ClienteResponse clienteParaClienteResponse (Cliente cliente, EnderecoService enderecoService) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setDataNascimento(cliente.getDataNascimento());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setEnderecoComplemento(cliente.getEnderecoComplemento());
        clienteResponse.setEnderecoNumero(cliente.getEnderecoNumero());
        enderecoService.viacep(cliente.getCep()).subscribe(clienteResponse::setEndereco);
        return clienteResponse;
    }

    public static ClienteResponse pesquisaParaTelefone (Cliente cliente) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setNome(cliente.getNome());
        return clienteResponse;
    }




    public static Cliente clienteMonoParaCliente (Mono<Cliente> clienteMono, Cliente cliente) {
        clienteMono.subscribe(cliente1 ->  BeanUtils.copyProperties(cliente1, cliente));
//        clienteMono.subscribe(cliente1 -> System.out.println(cliente1.toString()));
        return cliente;
    }

}

