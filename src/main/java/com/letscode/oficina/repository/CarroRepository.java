package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Carro;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface CarroRepository extends ReactiveCrudRepository<Carro, String> {

    Flux<Carro> findCarroByPlaca(String placa);

}
