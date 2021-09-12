package com.letscode.oficina.service;

import com.letscode.oficina.repository.CarroRepository;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.Request.CarroRequest;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class CarroService {
    private CarroRepository carroRepository;

    public Mono<Carro> gravarCarro(Mono<CarroRequest> carroRequest){
        return carroRequest.map(Conversores::carroRequestParaCarro).
                flatMap(carroRepository::save);
    }

    public Flux<Carro> listarTodos(){
        return carroRepository.findAll();
    }

    public Mono<Carro> listarCarro(String placa){
        return carroRepository.findCarroByPlaca(placa);
    }

    public Mono<Carro> atualizarCarro(Mono<CarroRequest> carroRequest, String id){
        return carroRequest.map(Conversores::carroRequestParaCarro).doOnNext(e->e.setId(id)).
                flatMap(carroRepository::save);
    }

    public Mono<Void> deletarCarro(String id){
        return carroRepository.deleteById(id);
    }
}
