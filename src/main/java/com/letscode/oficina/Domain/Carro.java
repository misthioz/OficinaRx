package com.letscode.oficina.Domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Carro {

    @SerializedName("carPlate")
    private String placa;

    @SerializedName("carBrand")
    private String marca;

    @SerializedName("carColor")
    private String cor;

    @SerializedName("client")
    private Cliente cliente;

}
