package com.letscode.oficina.controller;

import com.letscode.oficina.Request.ClienteRequest;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cliente")
@AllArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;
    //CREATE
    @PostMapping
    public Cliente gravarCliente (@RequestBody ClienteRequest clienteRequest) {
        return clienteService.gravarCliente(clienteRequest);
    }


}
