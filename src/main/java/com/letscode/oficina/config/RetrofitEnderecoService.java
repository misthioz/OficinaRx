package com.letscode.oficina.config;

import com.letscode.oficina.domain.Endereco;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import reactor.core.publisher.Mono;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitEnderecoService {

    @GET("{cep}/json")
    @ResponseStatus(HttpStatus.OK)
    Mono<Endereco> getEndereco(@Path("cep") String cep);

}
