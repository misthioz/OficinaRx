package com.letscode.oficina.service;

import com.letscode.oficina.repository.TelefoneClienteRepository;
import com.letscode.oficina.transferobject.request.TelefoneClienteRequest;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.transferobject.response.ClienteResponse;
import com.letscode.oficina.transferobject.response.TelefoneClienteResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@AllArgsConstructor

public class TelefoneClienteService {

    private final TelefoneClienteRepository telefoneClienteRepository;
    private final ClienteService clienteService;

    public Mono<TelefoneCliente> gravarTelefoneCliente (Mono<TelefoneClienteRequest> telefoneRequestMono) {
        return telefoneRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .flatMap(telefoneClienteRepository::save);
    }

    public Flux<TelefoneClienteResponse> listarTodos() {
        Flux<TelefoneCliente> mapa = telefoneClienteRepository.findAll();
        Flux<TelefoneClienteResponse> telefoneClienteResponseFlux = mapa.map(this::telefoneClienteParaTelefoneClienteResponse);
        Flux<ClienteResponse> clienteResponseFlux = mapa.flatMap(clienteService::listarClientePorId);
        return telefoneClienteResponseFlux.zipWith(clienteResponseFlux).map(this::mapearObjetResposta);
    }

    private TelefoneClienteResponse mapearObjetResposta(Tuple2<TelefoneClienteResponse, ClienteResponse> objects) {
        objects.getT1().setClienteNome(objects.getT2().getNome());
        return objects.getT1();
    }

    public TelefoneClienteResponse telefoneClienteParaTelefoneClienteResponse(TelefoneCliente telefoneCliente) {
        TelefoneClienteResponse telefoneClienteResponse = TelefoneClienteResponse.from(telefoneCliente);
        System.out.println("Teste2");
        return telefoneClienteResponse;
    }

    public Flux<TelefoneCliente> listarPorCliente(String idCliente) {
        return telefoneClienteRepository.findTelefoneClienteByIdCliente(idCliente);
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
