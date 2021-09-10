package com.letscode.oficina.service;

import com.letscode.oficina.Repository.OrdemServicoRepository;
import com.letscode.oficina.Request.OrdemServicoRequest;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.response.OrdemServicoResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@Service
public class OrdemServicoService {


    private final OrdemServicoRepository ordemServicoRepository;

    public Flux<OrdemServico> listarOrdensService() {
        return ordemServicoRepository.findAll();
    }

    public Mono<OrdemServicoResponse> criarOrdemServicoService(OrdemServicoRequest ordemServicoRequest) {
        Mono<OrdemServico> ordemServicoMono = Mono.just(ordemServicoRequest).flatMap(this::generateOrdemServico).flatMap(ordemServicoRepository::save);

        return ordemServicoMono.map(this::generateOrdemServicoResponse);
    }

    private Mono<OrdemServico> generateOrdemServico(OrdemServicoRequest ordemServicoRequest){
        return Mono.just(ordemServicoRequest.convert());
    }

    private OrdemServicoResponse generateOrdemServicoResponse(OrdemServico ordemServico){
        OrdemServicoResponse ordemServicoResponse = new OrdemServicoResponse(ordemServico);
        return ordemServicoResponse;
    }



}
