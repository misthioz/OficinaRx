package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrdemServico {

    @SerializedName("orderId")
    private Integer id;

    @SerializedName("car")
    private Carro carro;

    @SerializedName("mechanic")
    private Mecanico mecanico;

    @SerializedName("status")
    private EnumStatus status;

    @SerializedName("data")
    private String data;

}
