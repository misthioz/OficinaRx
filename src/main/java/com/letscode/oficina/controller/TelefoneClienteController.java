package com.letscode.oficina.controller;

import com.letscode.oficina.request.TelefoneClienteRequest;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.response.ClienteResponse;
import com.letscode.oficina.response.TelefoneClienteResponse;
import com.letscode.oficina.service.TelefoneClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/telefonecliente")
@AllArgsConstructor
public class TelefoneClienteController {

    private final TelefoneClienteService telefoneClienteService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<TelefoneCliente> gravarTelefoneCliente(@RequestBody Mono<TelefoneClienteRequest> telefoneClienteRequestMono) {
        return telefoneClienteService.gravarTelefoneCliente(telefoneClienteRequestMono);
    }

    @GetMapping("listartodos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TelefoneClienteResponse> listarTodos() {
        return telefoneClienteService.listarTodos();
    }

    @GetMapping("listartodosporcliente")
    @ResponseStatus(HttpStatus.OK)
    public Flux<ClienteResponse> listarTodosPorCliente() {
        return telefoneClienteService.listarTodosPorCliente();
    }

    @GetMapping("pesquisar/{idCliente}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<TelefoneCliente> pesquisarTelPorCliente(@PathVariable String idCliente) {
        return telefoneClienteService.listarPorCliente(idCliente);
    }

    @PutMapping("atualizar/{idTelefone}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<TelefoneCliente> atualizarTelefone(@RequestBody Mono<TelefoneClienteRequest> telefoneClienteMono, @PathVariable String idTelefone) {
        return telefoneClienteService.atualizarTelefoneCliente(telefoneClienteMono, idTelefone);
    }

    @DeleteMapping("remover/{idTelefone}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> removerTelefoneCliente(@PathVariable String idTelefone) {
        return telefoneClienteService.deletarTelefoneCliente(idTelefone);
    }

}
