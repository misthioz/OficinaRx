package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Cliente;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends ReactiveCrudRepository<Cliente, String> {

}
