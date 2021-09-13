package com.letscode.oficina.controller;

import com.letscode.oficina.request.CarroRequest;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {

    private CarroService carroService;

    @PostMapping("adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Carro> gravarCarro(@RequestBody Mono<CarroRequest> carroRequest){
        return carroService.gravarCarro(carroRequest);
    }

    @GetMapping("listartodos")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Carro> listarCarros(){
        return carroService.listarTodos();
    }

    @GetMapping("buscar/{placa}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Carro> buscarPlaca(@PathVariable String placa){
        return carroService.listarCarro(placa);
    }

    @PutMapping("atualizar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Carro> atualizarCarro(@RequestBody Mono<CarroRequest> carroRequest,
                                      @PathVariable String id){
        return carroService.atualizarCarro(carroRequest, id);
    }

    @DeleteMapping("deletar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Void> deletarCarro(@PathVariable String id){
        return carroService.deletarCarro(id);
    }

}
