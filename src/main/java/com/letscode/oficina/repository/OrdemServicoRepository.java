package com.letscode.oficina.repository;

import com.letscode.oficina.domain.OrdemServico;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OrdemServicoRepository extends ReactiveCrudRepository<OrdemServico, Integer> {


}
