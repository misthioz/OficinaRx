package com.letscode.oficina.service;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.repository.MecanicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    public Mono<Mecanico> save(Mecanico mecanico) {
        // TODO
        return null;
    }

    public Flux<Mecanico> listAll() {
        return mecanicoRepository.findAll();
    }

    public Flux<Mecanico> findBySpeciality(Especialidade especialidade) {
        return mecanicoRepository.findMecanicosByEspecialidade(especialidade);
    }

    public Mono<Mecanico> findByName(String name) {
        return mecanicoRepository.findMecanicoByName(name);
    }

    public Mono<Mecanico> findById(String idMecanico) {
        return mecanicoRepository.findById(idMecanico);
    }

    public Mono<Void> deleteById(String idMecanico) {
        return mecanicoRepository.deleteById(idMecanico);
    }

}
