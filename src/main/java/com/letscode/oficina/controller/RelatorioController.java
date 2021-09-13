package com.letscode.oficina.controller;

import com.letscode.oficina.response.RelatorioResponse;
import com.letscode.oficina.service.RelatorioService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@RestController
@RequestMapping("/relatorio")
public class RelatorioController {
    private final RelatorioService relatorioService;

    @GetMapping("imprimir/{placa}")
    @ResponseStatus(HttpStatus.OK)
    public Flux<RelatorioResponse> imprimirRelatorioPorCarro(@PathVariable String placa){
        return relatorioService.imprimirRelatorio(placa);
    }
}
