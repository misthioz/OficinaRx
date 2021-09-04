package com.letscode.oficina.Controller;

import com.letscode.oficina.Domain.Endereco;
import com.letscode.oficina.Service.EnderecoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController()
@RequestMapping("/cep")
@AllArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @GetMapping("{cep}")
    public Mono<Endereco> retornaEndereco(@PathVariable String cep) {
        return enderecoService.viacep(cep);
    }
}