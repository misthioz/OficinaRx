package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TelefoneRepository extends MongoRepository<Cliente, String> {

}
