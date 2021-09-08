package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Cliente;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {

    public Mono<Cliente> findClienteByNomeIsLike(String nome);

}
