package com.letscode.oficina.controller;

import com.letscode.oficina.transferobject.request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.transferobject.response.ClienteResponse;
import com.letscode.oficina.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @PostMapping("adicionar")
    public Mono<Cliente> gravarCliente (@RequestBody Mono<ClienteRequest> clienteRequest) {
        return clienteService.gravarCliente(clienteRequest);
    }

    @GetMapping("listartodos")
    public Flux<ClienteResponse> listarTodos () {
        return clienteService.listarTodos();
    }

    @GetMapping("pesquisar/{nome}")
    public Flux<ClienteResponse> localizarClientePorNome(@PathVariable String nome) {
        return clienteService.listarCliente(nome);
    }

    @GetMapping("pesquisar/{id}")
    public Mono<Cliente> localizarClientePorId(@PathVariable String id) {
        return clienteService.listarClientePorId(id);
    }


    @PutMapping("atualizar/{id}")
    public Mono<Cliente> atualizarCliente(@RequestBody Mono<ClienteRequest> clienteRequest, @PathVariable String id) {
        return clienteService.atualizarCliente(clienteRequest, id);
    }

    @DeleteMapping("remover/{id}")
    public Mono<Void> removerCliente(@PathVariable String id) {
        return clienteService.deletarCliente(id);
    }

}
