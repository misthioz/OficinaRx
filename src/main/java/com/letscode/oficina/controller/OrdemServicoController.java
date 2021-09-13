package com.letscode.oficina.controller;

import com.letscode.oficina.request.OrdemServicoRequest;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.response.OrdemServicoResponse;
import com.letscode.oficina.service.OrdemServicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<OrdemServicoResponse> novaOrdemServico(@RequestBody OrdemServicoRequest ordemServicoRequest){
        return ordemServicoService.criarOrdemServicoService(ordemServicoRequest);
    }

    @GetMapping("listartodos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<OrdemServico> listarOrdensServico() {
        return ordemServicoService.listarOrdensService();
    }

    @DeleteMapping("delete/{idOrdem}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deletarOrdemServico(@PathVariable Integer idOrdem){
        return ordemServicoService.deletarOrdemServico(idOrdem);
    }

}



