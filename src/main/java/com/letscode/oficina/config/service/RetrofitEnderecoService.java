package com.letscode.oficina.config.service;

import com.letscode.oficina.domain.Endereco;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitEnderecoService {

    @GET("{cep}/json")
    Mono<Endereco> getEndereco(@Path("cep") String cep);

}
