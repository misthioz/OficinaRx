package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Endereco {

    @SerializedName("zipCode")
    private String cep;

    @SerializedName("street")
    private String logradouro;

    @SerializedName("streetNumber")
    private String complemento;

    @SerializedName("district")
    private String bairro;

    @SerializedName("city")
    private String localidade;

    @SerializedName("state")
    private String uf;

}
