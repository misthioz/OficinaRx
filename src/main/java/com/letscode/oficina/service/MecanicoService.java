package com.letscode.oficina.service;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.repository.MecanicoRepository;
import com.letscode.oficina.request.MecanicoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    public Flux<Mecanico> listAll() {
        return mecanicoRepository.findAll();
    }

    public Mono<Mecanico> save(Mecanico mecanico) {
        return null; //mecanico.mapflatMap(mecanicoRepository::insert);
    }

    public Mono<Mecanico> findByName(String name) {
        return null;
    }

    public Mono<Mecanico> findById(String idMecanico) {
        return null;
    }

    public Mono<Void> deleteById(String idMecanico) {
        return null;
    }

    public Flux<Mecanico> findBySpeciality(Especialidade especialidade) {
        return null;
    }
}
