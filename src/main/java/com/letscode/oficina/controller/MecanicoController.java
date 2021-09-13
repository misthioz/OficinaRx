package com.letscode.oficina.controller;

import com.letscode.oficina.request.MecanicoRequest;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.response.MecanicoResponse;
import com.letscode.oficina.service.MecanicoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/mecanico")
@AllArgsConstructor
public class MecanicoController {

    private final MecanicoService mecanicoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Mecanico> adicionarMecanico(@RequestBody Mono<MecanicoRequest> mecanicoRequest) {
        return mecanicoService.gravarMecanico(mecanicoRequest);
    }

    @GetMapping("listartodos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MecanicoResponse> listarTodos() {
        return mecanicoService.listarTodos();
    }

    @GetMapping("pesquisar/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<MecanicoResponse> localizarMecanicoPorNome(@PathVariable String nome) {
        return mecanicoService.listarMecanicoPorNome(nome);
    }

    @GetMapping("pesquisar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Mecanico> localizarMecanicoPorId(@PathVariable String id) {
        return mecanicoService.listarMecanicoPorId(id);
    }

    @PutMapping("atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Mecanico> atualizarMecanico(@RequestBody Mono<MecanicoRequest> mecanicoRequestMono, @PathVariable String id) {
        return mecanicoService.atualizarMecanico(mecanicoRequestMono, id);
    }

    @DeleteMapping("remover/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> removerMecanico(@PathVariable String id) {
        return mecanicoService.deletarMecanico(id);
    }

}