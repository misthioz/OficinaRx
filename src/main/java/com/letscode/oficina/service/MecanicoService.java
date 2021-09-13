package com.letscode.oficina.service;

import com.letscode.oficina.request.MecanicoRequest;
import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.repository.MecanicoRepository;
import com.letscode.oficina.response.MecanicoResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@AllArgsConstructor
public class MecanicoService {

    private final MecanicoRepository mecanicoRepository;
    private final EnderecoService enderecoService;
    private final EspecialidadeService especialidadeService;

    public Mono<Mecanico> gravarMecanico(Mono<MecanicoRequest> mecanicoRequestMono) {
        return mecanicoRequestMono.map(Conversores::mecanicoRequestParaMecanico)
                .flatMap(mecanicoRepository::save);
    }

    public Flux<MecanicoResponse> listarTodos() {
        Flux<Mecanico> mecanicoFlux = mecanicoRepository.findAll();
        Flux<MecanicoResponse> mecanicoResponseFlux = mecanicoFlux
                .map(mecanico -> Conversores.mecanicoParaMecanicoResponse(mecanico, enderecoService));
        Flux<Especialidade> especialidadeFlux = mecanicoResponseFlux.flatMap(especialidadeService::listarPorIdParaMecanico);
        return mecanicoResponseFlux.zipWith(especialidadeFlux).map(this::mapearObjectResposta);
    }

    private MecanicoResponse mapearObjectResposta(Tuple2<MecanicoResponse, Especialidade> objects) {
        objects.getT1().setEspecialidade(objects.getT2().getEspecialidade());
        return objects.getT1();
    }

    public Flux<MecanicoResponse> listarMecanicoPorNome(String nome) {
        return mecanicoRepository.findMecanicoByNomeIsLike(nome);
    }

    public Mono<Mecanico> listarMecanicoPorId(String id) {
        return mecanicoRepository.findById(id);
    }

    public Mono<Mecanico> atualizarMecanico(Mono<MecanicoRequest> mecanicoRequestMono, String id) {
        return mecanicoRequestMono.map(Conversores::mecanicoRequestParaMecanico)
                .doOnNext(e -> e.setId(id)).flatMap(mecanicoRepository::save);
    }

    public Mono<Void> deletarMecanico(String id) {
        return mecanicoRepository.deleteById(id);
    }

}