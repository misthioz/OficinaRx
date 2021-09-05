package com.letscode.oficina.Domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Cliente {

    @SerializedName("clientId")
    private Integer id;

    @SerializedName("clientName")
    private String nome;

    @SerializedName("clientAge")
    private Integer idade;

    @SerializedName("clientAddress")
    private Endereco endereco;

    @SerializedName("clientTelephones")
    private List<String> telefones;

}
