package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Mecanico;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface MecanicoRepository extends ReactiveMongoRepository<Mecanico, String> {

}
