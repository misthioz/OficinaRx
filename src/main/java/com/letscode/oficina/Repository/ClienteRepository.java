package com.letscode.oficina.Repository;

import com.letscode.oficina.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}
