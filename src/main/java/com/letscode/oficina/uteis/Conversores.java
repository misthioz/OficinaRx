package com.letscode.oficina.uteis;

import com.letscode.oficina.request.*;
import com.letscode.oficina.domain.*;
import com.letscode.oficina.response.*;
import com.letscode.oficina.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

public class Conversores {

    public static ClienteRequest clienteParaClienteRequest(Cliente cliente) {
        ClienteRequest clienteRequest = new ClienteRequest();
        BeanUtils.copyProperties(cliente, clienteRequest);
        return clienteRequest;
    }

    public static Cliente clienteRequestParaCliente(ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        return cliente;
    }

    public static Carro carroRequestParaCarro(CarroRequest carroRequest) {
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroRequest, carro);
        return carro;
    }

    public static Especialidade especialidadeRequestParaEspecialidade(EspecialidadeRequest especialidadeRequest) {
        Especialidade especialidade = new Especialidade();
        BeanUtils.copyProperties(especialidadeRequest, especialidade);
        return especialidade;
    }

    public static EspecialidadeResponse especialidadeParaEspecialidadeResponse(Especialidade especialidade) {
        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse();
        especialidadeResponse.setEspecialidade(especialidade.getEspecialidade());
        return especialidadeResponse;
    }

    public static TelefoneCliente telefoneClienteRequestParaTelefoneCliente(TelefoneClienteRequest telefoneClienteRequest) {
        TelefoneCliente telefoneCliente = new TelefoneCliente();
        BeanUtils.copyProperties(telefoneClienteRequest, telefoneCliente);
        return telefoneCliente;
    }

    public static TelefoneClienteResponse telefoneClienteParaTelefoneClienteResponse(TelefoneCliente telefoneCliente) {
        TelefoneClienteResponse telefoneClienteResponse = new TelefoneClienteResponse();
        telefoneClienteResponse.setTelefone(telefoneCliente.getTelefone());
        telefoneClienteResponse.setIdCliente(telefoneCliente.getIdCliente());
        telefoneClienteResponse.setIdTelefone(telefoneCliente.getId());
        return telefoneClienteResponse;
    }

    public static ClienteResponse clienteParaClienteResponse(Cliente cliente, EnderecoService enderecoService) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setDataNascimento(cliente.getDataNascimento());
        clienteResponse.setNome(cliente.getNome());
        clienteResponse.setEnderecoComplemento(cliente.getEnderecoComplemento());
        clienteResponse.setEnderecoNumero(cliente.getEnderecoNumero());
        enderecoService.viacep(cliente.getCep()).subscribe(clienteResponse::setEndereco);
        return clienteResponse;
    }

    public static ClienteResponse pesquisaParaTelefone(Cliente cliente) {
        ClienteResponse clienteResponse = new ClienteResponse();
        clienteResponse.setNome(cliente.getNome());
        return clienteResponse;
    }

    public static Cliente clienteMonoParaCliente(Mono<Cliente> clienteMono, Cliente cliente) {
        clienteMono.subscribe(cliente1 -> BeanUtils.copyProperties(cliente1, cliente));
        return cliente;
    }

    public static Mecanico mecanicoRequestParaMecanico(MecanicoRequest mecanicoRequest) {
        Mecanico mecanico = new Mecanico();
        BeanUtils.copyProperties(mecanicoRequest, mecanico);
        return mecanico;
    }

    public static MecanicoResponse mecanicoParaMecanicoResponse(Mecanico mecanico, EnderecoService enderecoService) {
        MecanicoResponse mecanicoResponse= new MecanicoResponse();
        mecanicoResponse.setId(mecanico.getId());
        mecanicoResponse.setCep(mecanico.getCep());
        mecanicoResponse.setEnderecoComplemento(mecanicoResponse.getEnderecoComplemento());
        mecanicoResponse.setEnderecoNumero(mecanico.getEnderecoNumero());
        mecanicoResponse.setNome(mecanico.getNome());
        mecanicoResponse.setIdEspecialidade(mecanico.getIdEspecialidade());
        enderecoService.viacep(mecanico.getCep()).subscribe(mecanicoResponse::setEndereco);
        return mecanicoResponse;
    }

    public static OrdemServicoResponse ordemServicoParaOrdemServicoResponse(OrdemServico ordemServico) {
        OrdemServicoResponse ordemServicoResponse = new OrdemServicoResponse();
        ordemServicoResponse.setData(ordemServico.getData());
        ordemServicoResponse.setId(ordemServico.getId());
        ordemServicoResponse.setIdCarro(ordemServico.getIdCarro());
        ordemServicoResponse.setIdCliente(ordemServico.getIdCliente());
        ordemServicoResponse.setStatus(ordemServico.getStatus());
        ordemServicoResponse.setIdMecanico(ordemServico.getIdMecanico());
        return ordemServicoResponse;
    }
}