package com.letscode.oficina.Domain;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Mecanico {

    @SerializedName("mechanicId")
    private Integer id;

    @SerializedName("mechanicName")
    private String name;

    @SerializedName("mechanicAddress")
    private Endereco endereco;

    @SerializedName("mechanicSpeciality")
    private String especialidade;

}
