package com.letscode.oficina.service;

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



    public Flux<Mecanico> listarTodos() {
        // TODO
        return null;
    }

    public Mono<Mecanico> save(Mecanico mecanico) {
        return null;
    }

    public Flux<Object> findByName(String name) {
        return null;
    }

    public Mono<Void> deleteById(String idMecanico) {
        return null;
    }
}
