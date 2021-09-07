package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @SerializedName("mechanicId")
    private Integer id;

    @SerializedName("mechanicName")
    private String name;

    @SerializedName("mechanicAddress")
    private Endereco endereco;

    @SerializedName("mechanicSpeciality")
    private Especialidade especialidade;

}
