package com.letscode.oficina.service;

import com.letscode.oficina.repository.ClienteRepository;
import com.letscode.oficina.repository.TelefoneClienteRepository;
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

    public Flux<ClienteResponse> listarTodosPorCliente() {
        Flux<Cliente> clienteFlux = clienteRepository.findAll();
        Flux<ClienteResponse> clienteResponseFlux = clienteFlux
                .map(cliente -> clienteParaClienteResponse(cliente));

        return clienteResponseFlux;
    }

    public ClienteResponse clienteParaClienteResponse(Cliente cliente){
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setId(cliente.getId());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setDataNascimento(cliente.getDataNascimento());
        clienteResponse.setEnderecoComplemento(cliente.getEnderecoComplemento());
        clienteResponse.setEnderecoNumero(cliente.getEnderecoNumero());
        preencherTelefones(clienteResponse);

        return clienteResponse;
    }

    private TelefoneClienteResponse mapearObjetResposta(Tuple2<TelefoneClienteResponse, ClienteResponse> objects) {
        objects.getT1().setClienteNome(objects.getT2().getNome());
        return objects.getT1();
    }


    public Flux<TelefoneCliente> listarPorCliente (String idCliente) {
        return telefoneClienteRepository.findTelefoneClienteByIdCliente(idCliente);

    }

//    private ClienteResponse toResponseTelefone(Cliente cliente) {
//        ClienteResponse clienteResponse = ClienteResponse.convert(cliente);
//        preencherTelefones(clienteResponse);
//
//        return clienteResponse;
//    }

    private void preencherTelefones(ClienteResponse clienteResponse) {
        clienteResponse.setTelefones(new ArrayList<>());
        telefoneClienteRepository.findAllByIdCliente(clienteResponse.getId()).filter(Objects::nonNull).subscribe(telefoneCliente ->
        {
            TelefoneClienteResponseMinimal telefoneClienteResponseMinimal = new TelefoneClienteResponseMinimal(telefoneCliente);
            telefoneClienteResponseMinimal.setTelefone(telefoneCliente.getTelefone());
            clienteResponse.getTelefones().add(telefoneClienteResponseMinimal);
            System.out.println(clienteResponse + "preencher");
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
