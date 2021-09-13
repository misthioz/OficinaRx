package com.letscode.oficina.service;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.OrdemServico;
import com.letscode.oficina.repository.CarroRepository;
import com.letscode.oficina.repository.ClienteRepository;
import com.letscode.oficina.repository.MecanicoRepository;
import com.letscode.oficina.repository.OrdemServicoRepository;
import com.letscode.oficina.response.RelatorioResponse;
import com.letscode.oficina.uteis.Conversores;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class RelatorioService {
    private CarroRepository carroRepository;
    private MecanicoRepository mecanicoRepository;
    private ClienteRepository clienteRepository;
    private OrdemServicoService ordemServicoService;

    public Flux<RelatorioResponse> imprimirRelatorio(String placa) {
        Flux<Carro> carroFlux = carroRepository.findCarroByPlaca(placa);
        Flux<OrdemServico> ordemServicoFlux = ordemServicoService.findByIdCarro()
    }


}
