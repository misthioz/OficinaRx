package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.response.MecanicoResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface MecanicoRepository extends ReactiveMongoRepository<Mecanico, String> {
    Flux<Mecanico> findMecanicosByEspecialidade(Especialidade especialidade);
    Mono<Mecanico> findMecanicoByName(String nome);
}
