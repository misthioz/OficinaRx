package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("Carro")
public class Carro {

    @Id
    private String id;

    @SerializedName("carPlate")
    private String placa;

    @SerializedName("carBrand")
    private String marca;

    @SerializedName("carColor")
    private String cor;

    @SerializedName("client")
    private Cliente cliente;

}
