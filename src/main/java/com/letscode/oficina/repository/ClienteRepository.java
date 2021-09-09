package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Cliente;

import com.letscode.oficina.response.ClienteResponse;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {
    public Flux<ClienteResponse> findClienteByNomeIsLike(String nome);
}
