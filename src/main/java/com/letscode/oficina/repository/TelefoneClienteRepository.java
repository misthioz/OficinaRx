package com.letscode.oficina.repository;

import com.letscode.oficina.domain.TelefoneCliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TelefoneClienteRepository extends ReactiveCrudRepository<TelefoneCliente, String> {

    Flux<TelefoneCliente> findTelefoneClienteByIdCliente(String idCliente);

}
