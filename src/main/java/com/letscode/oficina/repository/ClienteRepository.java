package com.letscode.oficina.repository;

import com.letscode.oficina.domain.Cliente;

import com.letscode.oficina.response.ClienteResponse;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface ClienteRepository extends ReactiveCrudRepository<Cliente, String> {

    public Flux<ClienteResponse> findClienteByNomeIsLike(String nome);


}
