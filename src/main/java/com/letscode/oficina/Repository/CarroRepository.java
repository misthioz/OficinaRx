package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Carro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface CarroRepository extends ReactiveMongoRepository<Carro, String> {
    public Mono<Carro> findCarroByPlaca(String placa);
}
