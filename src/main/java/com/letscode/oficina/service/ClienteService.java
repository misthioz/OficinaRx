package com.letscode.oficina.service;

import com.letscode.oficina.repository.ClienteRepository;
import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Endereco;
import com.letscode.oficina.response.ClienteResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
@AllArgsConstructor
public class ClienteService {

    private final EnderecoService enderecoService;
    private final ClienteRepository clienteRepository;

    public Mono<Cliente> gravarCliente(Mono<ClienteRequest> clienteRequest) {
       return clienteRequest.map(Conversores::clienteRequestParaCliente).
               flatMap(clienteRepository::insert);
    }

    //TODO Pesquisar como retornar o clientResponse?
    public Flux<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }


    public Flux<ClienteResponse> listarCliente(String nome) {
        return clienteRepository.findClienteByNomeIsLike(nome);

    }

  //  return users.flatMap(u -> roleRepo.findById(u.getRoleId()).map(r -> new UserDto(u, r)));


    public Mono<Cliente> atualizarCliente(Mono<ClienteRequest> clienteRequestMono, String id) {
        return clienteRequestMono.map(Conversores::clienteRequestParaCliente).doOnNext(e->e.setId(id)).
                flatMap(clienteRepository::save);
    }

    public Mono<Void> deletarCliente (String id) {
        return clienteRepository.deleteById(id);
    }

}
