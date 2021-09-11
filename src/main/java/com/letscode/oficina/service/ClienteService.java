package com.letscode.oficina.service;

import com.letscode.oficina.repository.ClienteRepository;
import com.letscode.oficina.transferobject.request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.transferobject.response.ClienteResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class ClienteService {

    private final EnderecoService enderecoService;
    private final ClienteRepository clienteRepository;

    public Mono<Cliente> gravarCliente(Mono<ClienteRequest> clienteRequest) {
       return clienteRequest.map(Conversores::clienteRequestParaCliente).
               flatMap(clienteRepository::save);
    }

    //TODO Pesquisar como retornar o clientResponse?
    public Flux<ClienteResponse> listarTodos() {
        return clienteRepository.findAll().map(this::convertToResponse);
    }

    private ClienteResponse convertToResponse(Cliente cliente) {
        ClienteResponse clienteResponse = ClienteResponse.from(cliente);
        clienteResponse.setTelefones(new ArrayList<>());
        return clienteResponse;
    }

    public Flux<ClienteResponse> listarCliente(String nome) {
        return clienteRepository.findClienteByNomeIsLike(nome);
    }

    public Mono<Cliente> listarClientePorId(String id) {
        System.out.println("Listando");
        return clienteRepository.findById(id);
    }

    public Mono<Cliente> atualizarCliente(Mono<ClienteRequest> clienteRequestMono, String id) {
        return clienteRequestMono.map(Conversores::clienteRequestParaCliente).doOnNext(e->e.setId(id)).
                flatMap(clienteRepository::save);
    }

    public Mono<Void> deletarCliente (String id) {
        return clienteRepository.deleteById(id);
    }
}