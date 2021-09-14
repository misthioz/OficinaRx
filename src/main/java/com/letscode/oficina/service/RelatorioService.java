package com.letscode.oficina.service;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.repository.CarroRepository;
import com.letscode.oficina.response.OrdemServicoResponse;
import com.letscode.oficina.response.RelatorioResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@AllArgsConstructor
@Service
public class RelatorioService {

    private CarroRepository carroRepository;
    private MecanicoService mecanicoService;
    private ClienteService clienteService;
    private OrdemServicoService ordemServicoService;

    public Flux<RelatorioResponse> imprimirRelatorio(String placa) {
        Mono<Carro> carroMono = carroRepository.findCarroByPlaca(placa);
        Carro carro = Conversores.carroMonoParaCarro(carroMono);
        Flux<OrdemServico> ordemServicoFlux = ordemServicoService.findAllByIdCarro(carro.getId());
        Flux<Mecanico> mecanicoFlux = ordemServicoFlux.flatMap(mecanicoService::listarMecanicoPorIdParaOS);
        Flux<Cliente> clienteFlux = ordemServicoFlux.flatMap(clienteService::listarClientePorIdParaOS);
        return ordemServicoFlux
                .map(Conversores::ordemServicoParaOrdemServicoResponse)
                .zipWith(mecanicoFlux).map(this::unirOScomMecanico)
                .zipWith(clienteFlux).map(this::unirOScomCliente)
                .zipWith(carroMono).map(this::unirOScomCarro)
                .map(Conversores::ordemServicoResponseParaRelatorioResponse);
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

    private OrdemServicoResponse unirOScomMecanico(Tuple2<OrdemServicoResponse, Mecanico> objects) {
        objects.getT1().setNomeMecanico(objects.getT2().getNome());
        return objects.getT1();
    }

}
