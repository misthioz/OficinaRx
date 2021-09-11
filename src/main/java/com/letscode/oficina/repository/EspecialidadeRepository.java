package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Especialidade;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface EspecialidadeRepository extends ReactiveCrudRepository<Especialidade, String> {

    Flux<Especialidade> findEspecialidadeByIdMecanico(Long id);
    Mono<Void> deleteById(Long idEspecialidade);

}
