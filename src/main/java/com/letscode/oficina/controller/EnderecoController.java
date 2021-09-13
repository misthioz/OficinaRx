package com.letscode.oficina.controller;

import com.letscode.oficina.domain.Endereco;
import com.letscode.oficina.service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/cep")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("{cep}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Endereco> retornaEndereco(@PathVariable String cep) {
        return enderecoService.viacep(cep);
    }

}