package com.letscode.oficina.controller;
import com.letscode.oficina.Request.OrdemServicoRequest;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.response.OrdemServicoResponse;
import com.letscode.oficina.service.OrdemServicoService;
import io.reactivex.Observable;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@AllArgsConstructor
@RestController
@RequestMapping("/ordemServico")
public class OrdemServicoController {

    private final OrdemServicoService ordemServicoService;

    @GetMapping
    public Flux<OrdemServico> listarOrdensServico() {
        return ordemServicoService.listarOrdensService();
    }
//
//    @PostMapping
//    public Mono<OrdemServicoResponse> novaOrdemServico(@RequestBody OrdemServicoRequest ordemServicoRequest){
//        return ordemServicoService.criarOrdemServicoService(ordemServicoRequest);
//    }
    
}



