package com.letscode.oficina.service;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.request.OrdemServicoRequest;
import com.letscode.oficina.repository.OrdemServicoRepository;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.response.OrdemServicoResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@AllArgsConstructor
@Service
public class OrdemServicoService {

    private final OrdemServicoRepository ordemServicoRepository;
    private final MecanicoService mecanicoService;
    private final ClienteService clienteService;
    private final CarroService carroService;

    public Flux<OrdemServicoResponse> listarOrdensService() {
         Flux<OrdemServico> ordemServicoFlux = ordemServicoRepository.findAll();
         Flux<OrdemServicoResponse> ordemServicoResponseFlux = ordemServicoFlux.map(Conversores::ordemServicoParaOrdemServicoResponse);
         Flux<Mecanico> mecanicoFlux = ordemServicoFlux.flatMap(mecanicoService::listarMecanicoPorIdParaOS);
         Flux<Carro> carroFlux = ordemServicoFlux.flatMap(carroService::listarCarroPorIdParaOS);
         Flux<Cliente> clienteFlux = ordemServicoFlux.flatMap(clienteService::listarClientePorIdParaOS);
         return ordemServicoResponseFlux
                 .zipWith(mecanicoFlux).map(this::unirOScomMecanico)
                 .zipWith(clienteFlux).map(this::unirOScomCliente)
                 .zipWith(carroFlux).map(this::unirOScomCarro);
    }

    private OrdemServicoResponse unirOScomCarro(Tuple2<OrdemServicoResponse, Carro> objects) {
        objects.getT1().setPlacaCarro(objects.getT2().getPlaca());
        objects.getT1().setMarcaCarro(objects.getT2().getMarca());
        return  objects.getT1();
    }

    private OrdemServicoResponse unirOScomCliente(Tuple2<OrdemServicoResponse, Cliente> objects) {
        objects.getT1().setNomeCliente(objects.getT2().getNome());
        return  objects.getT1();
    }

    private OrdemServicoResponse unirOScomMecanico (Tuple2<OrdemServicoResponse, Mecanico> objects) {
        objects.getT1().setNomeMecanico(objects.getT2().getNome());
        return objects.getT1();
    }

    public Mono<OrdemServicoResponse> criarOrdemServicoService(OrdemServicoRequest ordemServicoRequest) {
        Mono<OrdemServico> ordemServicoMono = Mono.just(ordemServicoRequest).flatMap(this::generateOrdemServico).flatMap(ordemServicoRepository::save);
        return ordemServicoMono.map(this::generateOrdemServicoResponse);
    }

    private Mono<OrdemServico> generateOrdemServico(OrdemServicoRequest ordemServicoRequest){
        return Mono.just(ordemServicoRequest.convert());
    }

    private OrdemServicoResponse generateOrdemServicoResponse(OrdemServico ordemServico){
        return new OrdemServicoResponse(ordemServico);
    }

    public Mono<Void> deletarOrdemServico(Integer idOrdem){
        return ordemServicoRepository.deleteById(idOrdem);
    }

}
