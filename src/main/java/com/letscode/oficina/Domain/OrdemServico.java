package com.letscode.oficina.Domain;

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

    private Carro carro;
    private EnumStatus status;
    private String data;

}
