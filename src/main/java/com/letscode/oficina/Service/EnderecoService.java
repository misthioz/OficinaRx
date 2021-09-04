package com.letscode.oficina.Service;

import com.letscode.oficina.Config.RetrofitEnderecoService;
import com.letscode.oficina.Config.RetrofitInitializer;
import com.letscode.oficina.Domain.Endereco;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import retrofit2.Retrofit;

@Service
public class EnderecoService {


    private final Retrofit retrofit;

    @Autowired
    public EnderecoService() {
        this.retrofit = RetrofitInitializer.getRetrofit();;
    }

    public Mono<Endereco> viacep(String cep) {

        return this.retrofit.create(RetrofitEnderecoService.class).getEndereco(cep);
    }
}
