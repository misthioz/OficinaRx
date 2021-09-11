package com.letscode.oficina.service;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.repository.EspecialidadeRepository;
import com.letscode.oficina.transferobject.request.EspecialidadeRequest;
import com.letscode.oficina.transferobject.response.EspecialidadeResponse;
import com.letscode.oficina.transferobject.response.MecanicoResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
@AllArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;
    private final MecanicoService mecanicoService;

    public Mono<Especialidade> gravarEspecialidade(Mono<EspecialidadeRequest> especialidadeRequestMono) {
        return especialidadeRequestMono.map(Conversores::especialidadeRequestParaEspecialidade)
                .flatMap(especialidadeRepository::save);
    }

    public Flux<EspecialidadeResponse> listarTodas() {
        Flux<Especialidade> mapa = especialidadeRepository.findAll();
        Flux<EspecialidadeResponse> especialidadeResponseFlux = mapa.map(this::especialidadeParaEspecialidadeResponse);
        Flux<MecanicoResponse> mecanicoResponseFlux = mapa.flatMap(mecanicoService::listarMecanicoPorId);
        return especialidadeResponseFlux.zipWith(mecanicoResponseFlux).map(this::mapearObjetoResposta);
    }

    private EspecialidadeResponse mapearObjetoResposta(Tuple2<EspecialidadeResponse, MecanicoResponse> objects) {
        objects.getT1().setMecanicoNome(objects.getT2().getNome());
        return objects.getT1();
    }

    public EspecialidadeResponse especialidadeParaEspecialidadeResponse(Especialidade especialidade) {
        EspecialidadeResponse especialidadeResponse = EspecialidadeResponse.from(especialidade);
        return especialidadeResponse;
    }

    public Flux<Especialidade> listarPorMecanico(Long id) {
        return especialidadeRepository.findEspecialidadeByIdMecanico(id);
    }

    public Mono<Especialidade> atualizarEspecialidade(Mono<EspecialidadeRequest> especialidadeRequestMono, Long idMecanico) {
        return especialidadeRequestMono.map(Conversores::especialidadeRequestParaEspecialidade)
                .doOnNext(e -> e.setId(idMecanico))
                .flatMap(especialidadeRepository::save);
    }

    public Mono<Void> deletarEspecialidade(Long idEspecialidade) {
        return especialidadeRepository.deleteById(idEspecialidade);
    }

}
