package com.letscode.oficina.service;

import com.letscode.oficina.Repository.TelefoneClienteRepository;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.ClienteResponse;
import com.letscode.oficina.response.TelefoneClienteResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Objects;

@Service
@AllArgsConstructor

public class TelefoneClienteService {

    private final ClienteService clienteService;
    private final TelefoneClienteRepository telefoneClienteRepository;


    public Mono<TelefoneCliente> gravarTelefoneCliente (Mono<TelefoneClienteRequest> telefoneRequestMono) {
        return telefoneRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .flatMap(telefoneClienteRepository::save);
    }

    public Flux<TelefoneClienteResponse> listarTodos() {
        Flux<TelefoneClienteResponse> map = telefoneClienteRepository.findAll()
                .map(this::telefoneClienteParaTelefoneClienteResponse);

        return map;

    }

    public Mono<Cliente> clienteFlux(String idCliente) {
        Mono<Cliente> clienteMono = clienteService.listarClientePorId(idCliente);
        return clienteMono;
    }

    public TelefoneClienteResponse telefoneClienteParaTelefoneClienteResponse (TelefoneCliente telefoneCliente) {
        TelefoneClienteResponse telefoneClienteResponse = new TelefoneClienteResponse();
        clienteFlux(telefoneCliente.getIdcliente()).subscribe(cliente -> System.out.println(cliente.toString()));
        telefoneClienteResponse.setIdTelefone(telefoneCliente.getId());
        telefoneClienteResponse.setTelefone(telefoneCliente.getTelefone());
        telefoneClienteResponse.setIdCliente(telefoneCliente.getIdcliente());



        System.out.println("Teste2");
        return telefoneClienteResponse;
    }

    private ClienteResponse extracted(TelefoneClienteResponse telefoneClienteResponse) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteService.listarClientePorId(telefoneClienteResponse.getIdCliente()).filter(Objects::nonNull)
                .subscribe(cliente -> {
                    clienteResponse.setNome(cliente.getNome());
                    System.out.println("teste");
                });

        return clienteResponse;
    }


    public Flux<TelefoneCliente> listarPorCliente (String idCliente) {
        return telefoneClienteRepository.findTelefoneClienteByIdcliente(idCliente);

    }

    public Mono<TelefoneCliente> atualizarTelefoneCliente(Mono<TelefoneClienteRequest> telefoneClienteRequestMono, String idTelefone) {
        return telefoneClienteRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .doOnNext(t -> t.setId(idTelefone))
                .flatMap(telefoneClienteRepository::save);

    }

    public Mono<Void> deletarTelefoneCliente (String idTelefone) {
        return telefoneClienteRepository.deleteById(idTelefone);
    }


}
