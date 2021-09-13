package com.letscode.oficina.service;

import com.letscode.oficina.request.EspecialidadeRequest;
import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.repository.EspecialidadeRepository;
import com.letscode.oficina.response.EspecialidadeResponse;
import com.letscode.oficina.response.MecanicoResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EspecialidadeService {

    private final EspecialidadeRepository especialidadeRepository;

    public Mono<Especialidade> gravarEspecialidade(Mono<EspecialidadeRequest> especialidadeRequestMono) {
        return especialidadeRequestMono.map(Conversores::especialidadeRequestParaEspecialidade)
                .flatMap(especialidadeRepository::save);
    }

    public Flux<EspecialidadeResponse> listarTodas() {
        return especialidadeRepository.findAll()
                .map(Conversores::especialidadeParaEspecialidadeResponse);
    }

    public Flux<EspecialidadeResponse> listarPorNome(String nome) {
        return especialidadeRepository.findEspecialidadeByEspecialidadeLike(nome).map(Conversores::especialidadeParaEspecialidadeResponse);
    }

    public Mono<Especialidade> listarPorIdParaMecanico(MecanicoResponse menanicoResponse) {
        return especialidadeRepository.findById(menanicoResponse.getIdEspecialidade());
    }

    public Mono<Especialidade> atualizarEspecialidade(Mono<EspecialidadeRequest> especialidadeRequestMono, String id) {
        return especialidadeRequestMono.map(Conversores::especialidadeRequestParaEspecialidade)
                .doOnNext(e -> e.setId(id))
                .flatMap(especialidadeRepository::save);
    }

    public Mono<Void> deletarEspecialidade(String idEspecialidade) {
        return especialidadeRepository.deleteById(idEspecialidade);
    }

}