package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Carro;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarroRepository extends ReactiveCrudRepository<Carro, String> {

    public Mono<Carro> findCarroByPlaca(String placa);
}
