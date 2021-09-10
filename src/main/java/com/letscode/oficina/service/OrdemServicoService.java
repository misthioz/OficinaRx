package com.letscode.oficina.service;

import com.letscode.oficina.Repository.OrdemServicoRepository;
import com.letscode.oficina.domain.OrdemServico;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;


@AllArgsConstructor
@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;

    public Flux<OrdemServico> listarOrdensService() {

        return null;
    }


}
