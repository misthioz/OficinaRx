package com.letscode.oficina.service;

import com.letscode.oficina.Repository.TelefoneClienteRepository;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor

public class TelefoneClienteService {

    private final TelefoneClienteRepository telefoneClienteRepository;

    public Mono<TelefoneCliente> gravarTelefoneCliente (Mono<TelefoneClienteRequest> telefoneRequestMono) {
        return telefoneRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .flatMap(telefoneClienteRepository::insert);
    }

    public Flux<TelefoneCliente> listarTodos() {
        return telefoneClienteRepository.findAll();
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
