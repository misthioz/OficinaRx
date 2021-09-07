package com.letscode.oficina.service;

import com.letscode.oficina.Repository.ClienteRepository;
import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;

    //TODO Criar o ClienteResponse
    public Cliente gravarCliente(ClienteRequest clienteRequest) {
        Cliente cliente = clienteRequest.convert();
        return clienteRepository.save(cliente);
    }
}
