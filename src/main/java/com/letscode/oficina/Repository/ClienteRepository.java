package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Cliente;

import com.letscode.oficina.response.ClienteResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface ClienteRepository extends ReactiveMongoRepository<Cliente, String> {

    public Flux<ClienteResponse> findClienteByNomeIsLike(String nome);




}
