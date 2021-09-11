package com.letscode.oficina.controller;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.service.EspecialidadeService;
import com.letscode.oficina.transferobject.request.EspecialidadeRequest;
import com.letscode.oficina.transferobject.response.EspecialidadeResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/especialidade")
@AllArgsConstructor
public class EspecialidadeController {

    private final EspecialidadeService especialidadeService;

    @PostMapping("adicionar")
    public Mono<Especialidade> gravarEspecialidade(@RequestBody Mono<EspecialidadeRequest> especialidadeRequestMono) {
        return especialidadeService.gravarEspecialidade(especialidadeRequestMono);
    }

    @GetMapping("listartodas")
    public Flux<EspecialidadeResponse> listarTodas() {
        return especialidadeService.listarTodas();
    }

    @GetMapping("pesquisar/{idMecanico}")
    public Flux<Especialidade> pesquisarEspecialidadePorMecanico(@PathVariable Long idMecanico) {
        return especialidadeService.listarPorMecanico(idMecanico);
    }

    @PutMapping("atualizar/{idEspecialidade}")
    public Mono<Especialidade> atualizarEspecialidade(@RequestBody Mono<EspecialidadeRequest> especialidadeRequestMono, @PathVariable Long idEspecialidade) {
        return especialidadeService.atualizarEspecialidade(especialidadeRequestMono, idEspecialidade);
    }

    @DeleteMapping("remover/{idEspecialidade")
    public Mono<Void> removerEspecialidade(@PathVariable Long idEspecialidade) {
        return especialidadeService.deletarEspecialidade(idEspecialidade);
    }

}
