
package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.response.MecanicoResponse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface MecanicoRepository extends ReactiveCrudRepository<Mecanico, String> {

    Flux<MecanicoResponse> findMecanicoByNomeIsLike(String nome);

}