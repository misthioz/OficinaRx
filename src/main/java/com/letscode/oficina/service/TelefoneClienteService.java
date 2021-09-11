package com.letscode.oficina.service;

import com.letscode.oficina.Repository.ClienteRepository;
import com.letscode.oficina.Repository.TelefoneClienteRepository;
import com.letscode.oficina.Request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.ClienteResponse;
import com.letscode.oficina.response.TelefoneClienteResponse;
import com.letscode.oficina.response.TelefoneClienteResponseMinimal;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.util.ArrayList;
import java.util.Objects;

import java.util.Objects;

@Service
@AllArgsConstructor
public class TelefoneClienteService {

    private final ClienteService clienteService;
    private final TelefoneClienteRepository telefoneClienteRepository;
    private final ClienteRepository clienteRepository;


    public Mono<TelefoneCliente> gravarTelefoneCliente (Mono<TelefoneClienteRequest> telefoneRequestMono) {
        return telefoneRequestMono.map(Conversores::telefoneClienteRequestParaTelefoneCliente)
                .flatMap(telefoneClienteRepository::save);
    }

    public Flux<TelefoneClienteResponse> listarTodos() {

        Flux<TelefoneCliente> telefonesclientesRetornados = telefoneClienteRepository.findAll();

        Flux<TelefoneClienteResponse> telefoneClienteResponseFlux = telefonesclientesRetornados
                .map(Conversores::telefoneClienteParaTelefoneClienteResponse);

        Flux<ClienteResponse>  clienteResponseFlux = telefonesclientesRetornados
                .flatMap(clienteService::listarClientePorIdParaTel);

        return telefoneClienteResponseFlux.zipWith(clienteResponseFlux).map(this::mapearObjetResposta);

    }

    private TelefoneClienteResponse mapearObjetResposta(Tuple2<TelefoneClienteResponse, ClienteResponse> objects) {
        objects.getT1().setClienteNome(objects.getT2().getNome());
        return objects.getT1();
    }


    public Flux<TelefoneCliente> listarPorCliente (String idCliente) {
        return telefoneClienteRepository.findTelefoneClienteByIdcliente(idCliente);

    }
    public Flux<ClienteResponse> listarTodosPorCliente() {
//        return telefoneClienteRepository.findAll().map(
//                telefoneCliente -> Conversores.telefoneClienteParaTelefoneClienteResponse(
//                                clienteService.listarClientePorId(telefoneCliente.getIdcliente()) , telefoneCliente)
//        );

        return clienteRepository.findAll().map(this::toResponseTelefone);
    }

    private ClienteResponse toResponseTelefone(Cliente cliente) {
        ClienteResponse clienteResponse = ClienteResponse.convert(cliente);
        preencherTelefones(clienteResponse);

        return clienteResponse;
    }

    private void preencherTelefones(ClienteResponse clienteResponse) {
        clienteResponse.setTelefones(new ArrayList<>());
        telefoneClienteRepository.findAllByIdcliente(clienteResponse.getId()).filter(Objects::nonNull).subscribe(telefoneCliente ->
        {
            TelefoneClienteResponseMinimal telefoneClienteResponseMinimal = new TelefoneClienteResponseMinimal();
            telefoneClienteResponseMinimal.setTelefone(telefoneCliente.getTelefone());
            clienteResponse.getTelefones().add(telefoneClienteResponseMinimal);
            System.out.println(clienteResponse);
        });
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
