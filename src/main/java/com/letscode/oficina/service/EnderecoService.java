package com.letscode.oficina.service;

import com.letscode.oficina.config.service.RetrofitEnderecoService;
import com.letscode.oficina.config.RetrofitInitializer;
import com.letscode.oficina.domain.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;

@Service
public class EnderecoService {

    private final Retrofit retrofit;

    @Autowired
    public EnderecoService() {
        this.retrofit = RetrofitInitializer.getRetrofit(true);
    }

    public Mono<Endereco> viacep(String cep) {
        return this.retrofit.create(RetrofitEnderecoService.class).getEndereco(cep);
    }

}
