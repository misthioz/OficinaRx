package com.letscode.oficina.service;

import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.repository.MecanicoRepository;
import com.letscode.oficina.transferobject.request.MecanicoRequest;
import com.letscode.oficina.transferobject.response.MecanicoResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class MecanicoService {

    private final MecanicoRepository mecanicoRepository;

    public Mono<Mecanico> gravarMecanico(Mono<MecanicoRequest> mecanicoRequestMono) {
        return mecanicoRequestMono.map(Conversores::mecanicoRequestParaMecanico)
                .flatMap(mecanicoRepository::save);
    }

    public Flux<MecanicoResponse> listarTodos() {
        return mecanicoRepository.findAll().map(this::convertToResponse);
    }

    private MecanicoResponse convertToResponse(Mecanico mecanico) {
        MecanicoResponse mecanicoResponse = MecanicoResponse.from(mecanico);
        mecanicoResponse.setEspecialidades(new ArrayList<>());
        return mecanicoResponse;
    }

    public Flux<MecanicoResponse> listarMecanicoPorNome(String nome) {
        return mecanicoRepository.findMecanicoByNomeIsLike(nome);
    }

    public Mono<Mecanico> listarMecanicoPorId(Long id) {
        return mecanicoRepository.findById(id);
    }

    public Mono<Mecanico> atualizarMecanico(Mono<MecanicoRequest> mecanicoRequestMono, Long id) {
        return mecanicoRequestMono.map(Conversores::mecanicoRequestParaMecanico)
                .doOnNext(e -> e.setId(id)).flatMap(mecanicoRepository::save);
    }

    public Mono<Void> deletarMecanico(Long id) {
        return mecanicoRepository.deleteById(id);
    }

}
