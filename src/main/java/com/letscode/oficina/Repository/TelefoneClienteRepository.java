package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.TelefoneCliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface TelefoneClienteRepository extends ReactiveCrudRepository<TelefoneCliente, String> {

    public Flux<TelefoneCliente> findTelefoneClienteByIdcliente(String idcliente);

    Flux<TelefoneCliente> findAllByIdcliente(String idCliente);
}
