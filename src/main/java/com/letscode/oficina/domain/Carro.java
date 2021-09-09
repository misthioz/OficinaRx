package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
public class Carro {

    @Id
    private String id;

    private String placa;
    private String marca;
    private String cor;
    private Cliente cliente;

}
