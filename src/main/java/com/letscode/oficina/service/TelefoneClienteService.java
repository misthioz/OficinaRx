package com.letscode.oficina.service;

import com.letscode.oficina.Repository.TelefoneClienteRepository;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.TelefoneClienteResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@AllArgsConstructor

public class TelefoneClienteService {

    private final ClienteService clienteService;
    private final TelefoneClienteRepository telefoneClienteRepository;


    public Mono<TelefoneCliente> gravarTelefoneCliente (Mono<TelefoneClienteRequest> telefoneRequestMono) {
        return telefoneRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .flatMap(telefoneClienteRepository::insert);
    }

    public Flux<TelefoneClienteResponse> listarTodos() {
        return telefoneClienteRepository.findAll().map(
                telefoneCliente -> Conversores.telefoneClienteParaTelefoneClienteResponse(
                                clienteService.listarClientePorId(telefoneCliente.getCliente().getId()) , telefoneCliente)
        );
    }



    public Flux<TelefoneCliente> listarPorCliente (String idCliente) {
        return telefoneClienteRepository.findTelefoneClienteByCliente_Id(idCliente);

    }

    public Mono<TelefoneCliente> atualizarTelefoneCliente(Mono<TelefoneClienteRequest> telefoneClienteRequestMono, String idTelefone) {
        return telefoneClienteRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .doOnNext(t -> t.setIdTelefone(idTelefone))
                .flatMap(telefoneClienteRepository::save);

    }

    public Mono<Void> deletarTelefoneCliente (String idTelefone) {
        return telefoneClienteRepository.deleteById(idTelefone);
    }


}
