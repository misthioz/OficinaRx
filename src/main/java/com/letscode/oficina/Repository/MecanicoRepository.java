package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Mecanico;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MecanicoRepository extends ReactiveCrudRepository<Mecanico, String> {

}
