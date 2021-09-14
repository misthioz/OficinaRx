package com.letscode.oficina.controller;

import com.letscode.oficina.response.OrdemServicoResponse;
import com.letscode.oficina.response.RelatorioResponse;
import com.letscode.oficina.service.RelatorioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/relatorios")
@AllArgsConstructor

public class RelatorioController {

    private RelatorioService relatorioService;

    @GetMapping("porplaca/{placa}")
    public Flux<RelatorioResponse> listarPorPlaca(@PathVariable String placa) {
        return relatorioService.imprimirRelatorio(placa);
    }

}
