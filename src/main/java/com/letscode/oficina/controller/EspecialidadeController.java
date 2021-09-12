
package com.letscode.oficina.controller;

import com.letscode.oficina.Request.EspecialidadeRequest;
import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.response.EspecialidadeResponse;
import com.letscode.oficina.service.EspecialidadeService;
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

    @GetMapping("pesquisar/{nome}")
    public Flux<EspecialidadeResponse> pesquisarEspecialidadePorNome(@PathVariable String nome) {
        return especialidadeService.listarPorNome(nome);
    }

    @PutMapping("atualizar/{idEspecialidade}")
    public Mono<Especialidade> atualizarEspecialidade(@RequestBody Mono<EspecialidadeRequest> especialidadeRequestMono, @PathVariable String idEspecialidade) {
        return especialidadeService.atualizarEspecialidade(especialidadeRequestMono, idEspecialidade);
    }

    @DeleteMapping("remover/{idEspecialidade}")
    public Mono<Void> removerEspecialidade(@PathVariable String idEspecialidade) {
        return especialidadeService.deletarEspecialidade(idEspecialidade);
    }

}