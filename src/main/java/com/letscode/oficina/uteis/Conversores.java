package com.letscode.oficina.uteis;

import com.letscode.oficina.domain.Especialidade;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.transferobject.request.CarroRequest;
import com.letscode.oficina.transferobject.request.ClienteRequest;
import com.letscode.oficina.transferobject.request.EspecialidadeRequest;
import com.letscode.oficina.transferobject.request.MecanicoRequest;
import com.letscode.oficina.transferobject.request.TelefoneClienteRequest;
import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.Cliente;
import com.letscode.oficina.domain.TelefoneCliente;
import com.letscode.oficina.transferobject.response.ClienteResponse;
import com.letscode.oficina.service.EnderecoService;
import org.springframework.beans.BeanUtils;
import reactor.core.publisher.Mono;

public class Conversores {


    public static ClienteRequest clienteParaClienteRequest (Cliente cliente) {
        ClienteRequest clienteRequest = new ClienteRequest();
        BeanUtils.copyProperties(cliente, clienteRequest);
        return clienteRequest;
    }

    public static Cliente clienteRequestParaCliente (ClienteRequest clienteRequest) {
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(clienteRequest, cliente);
        return cliente;
    }

    public static Carro carroRequestParaCarro(CarroRequest carroRequest){
        Carro carro = new Carro();
        BeanUtils.copyProperties(carroRequest,carro);
        return carro;
    }

    public static TelefoneCliente telefoneClienteRequestParaTelefoneCliente (TelefoneClienteRequest telefoneClienteRequest) {
        TelefoneCliente telefoneCliente = new TelefoneCliente();
        BeanUtils.copyProperties(telefoneClienteRequest, telefoneCliente);
        return telefoneCliente;
    }

    public static Mecanico mecanicoRequestParaMecanico(MecanicoRequest mecanicoRequest) {
        Mecanico mecanico = new Mecanico();
        BeanUtils.copyProperties(mecanicoRequest, mecanico);
        return mecanico;
    }

    public static Especialidade especialidadeRequestParaEspecialidade (EspecialidadeRequest especialidadeRequest) {
        Especialidade especialidade = new Especialidade();
        BeanUtils.copyProperties(especialidadeRequest, especialidade);
        return especialidade;
    }

    public static ClienteResponse clienteParaClienteResponse (Cliente cliente, EnderecoService enderecoService) {
        ClienteResponse clienteResponse = new ClienteResponse();
//        clienteResponse.setDataNascimento(cliente.getDataNascimento());
//        clienteResponse.setNome(cliente.getNome());
//        clienteResponse.setEnderecoComplemento(cliente.getEnderecoComplemento());
//        clienteResponse.setEnderecoNumero(cliente.getEnderecoNumero());
//        clienteResponse.setEndereco(enderecoMonoParaEndereco(enderecoService.viacep(cliente.getCep())));
//        enderecoService.viacep(cliente.getCep()).subscribe(clienteResponse::setEndereco);
        return clienteResponse;
    }

//    public static Endereco enderecoMonoParaEndereco (Mono<Endereco> enderecoMono) {
//        final Endereco enderecoCliente = new Endereco();
//        enderecoMono.subscribe(endereco -> System.out.println(endereco.getBairro()));
//        enderecoMono.subscribe(endereco -> BeanUtils.copyProperties(endereco, enderecoCliente));
//        return enderecoCliente;
//    }













    public static Cliente clienteMonoParaCliente (Mono<Cliente> clienteMono, Cliente cliente) {
        clienteMono.subscribe(cliente1 ->  BeanUtils.copyProperties(cliente1, cliente));
//        clienteMono.subscribe(cliente1 -> System.out.println(cliente1.toString()));
        return cliente;
    }

}

