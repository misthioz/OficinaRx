package com.letscode.oficina.controller;

import com.letscode.oficina.Request.CarroRequest;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.service.CarroService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/carro")
@AllArgsConstructor
public class CarroController {
    private CarroService carroService;

    @PostMapping("adicionar")
    public Mono<Carro> gravarCarro(@RequestBody Mono<CarroRequest> carroRequest){
        return carroService.gravarCarro(carroRequest);
    }

    @GetMapping("listarTodos")
    public Flux<Carro> listarCarros(){
        return carroService.listarTodos();
    }

    @GetMapping("buscar/{placa}")
    public Mono<Carro> buscarPlaca(@PathVariable String placa){
        return carroService.listarCarro(placa);
    }

    @PutMapping("atualizar/{id}")
    public Mono<Carro> atualizarCarro(@RequestBody Mono<CarroRequest> carroRequest,
                                      @PathVariable String id){
        return carroService.atualizarCarro(carroRequest, id);
    }

    @DeleteMapping("deletar/{id}")
    public Mono<Void> deletarCarro(@PathVariable String id){
        return carroService.deletarCarro(id);
    }
}
