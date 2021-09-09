package com.letscode.oficina.repository;

import com.letscode.oficina.domain.TelefoneCliente;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TelefoneClienteRepository extends ReactiveMongoRepository<TelefoneCliente, String> {
    public Flux<TelefoneCliente> findTelefoneClienteByCliente_Id(String idcliente);
}
