package com.letscode.oficina.controller;

import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.service.MecanicoService;
import com.letscode.oficina.transferobject.request.MecanicoRequest;
import com.letscode.oficina.transferobject.response.MecanicoResponse;
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
    public Flux<MecanicoResponse> localizarMecanicoPorNome(@PathVariable String nomeMecanico) {
        return mecanicoService.listarMecanicoPorNome(nomeMecanico);
    }

    @GetMapping("pesquisar/{id}")
    public Mono<Mecanico> localizarMecanicoPorId(@PathVariable Long id) {
        return mecanicoService.listarMecanicoPorId(id);
    }

    @PutMapping("atualizar/{id}")
    public Mono<Mecanico> atualizarMecanico(@RequestBody Mono<MecanicoRequest> mecanicoRequestMono, @PathVariable Long idMecanico) {
        return mecanicoService.atualizarMecanico(mecanicoRequestMono, idMecanico);
    }

    @DeleteMapping("remover/{id}")
    public Mono<Void> removerMecanico(@PathVariable Long idMecanico) {
        return mecanicoService.deletarMecanico(idMecanico);
    }

}
