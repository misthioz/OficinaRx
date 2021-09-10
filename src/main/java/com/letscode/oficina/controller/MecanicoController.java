package com.letscode.oficina.controller;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.exception.EspecialidadeNotFoundException;
import com.letscode.oficina.exception.MecanicoNotFoundException;
import com.letscode.oficina.service.MecanicoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/mecanico")
public class MecanicoController {

    private final MecanicoService mecanicoService;

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Mecanico> create(@Valid @RequestBody Mecanico mecanico) {
        return mecanicoService.save(mecanico);
    }

    @GetMapping("listartodos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Mecanico> listarTodos() {
        return mecanicoService.listAll();
    }

    @PutMapping("atualizar/{idMecanico}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Mecanico> update(@Valid @RequestBody Mono<Mecanico> mecanico) {
        return mecanico.flatMap(mecanicoService::save);
    }

    @GetMapping("/pesquisar/{idMecanico}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Mecanico> findMechanicById(@PathVariable String idMecanico) {
        return mecanicoService.findById(idMecanico)
                .switchIfEmpty(Mono.error(new MecanicoNotFoundException("Mecânico não encontrado.")));
    }

    @GetMapping("/pesquisar/{nome}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Mecanico> findMechanicByName(@PathVariable String name) {
        return mecanicoService.findByName(name)
                .switchIfEmpty(Mono.error(new MecanicoNotFoundException("Mecânico não encontrado.")));
    }
    @GetMapping("/pesquisar/{especialidade}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Mecanico> findMecanicosByEspecialidade(@PathVariable Especialidade especialidade) {
        return mecanicoService.findBySpeciality(especialidade)
                .switchIfEmpty(Mono.error(new EspecialidadeNotFoundException("Especialidade não encontrada.")));
    }

    @DeleteMapping("remover/{idMecanico}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Mono<Void> delete(@PathVariable String idMecanico) {
        return mecanicoService.deleteById(idMecanico);
    }

}