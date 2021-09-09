package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Carro;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface CarroRepository extends ReactiveMongoRepository<Carro, String> {
    public Mono<Carro> findCarroByPlaca(String placa);
}
