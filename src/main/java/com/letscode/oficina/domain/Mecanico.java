package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Mecanico")
public class Mecanico {

    @Id
    @SerializedName("mechanicId")
    private Integer id;

    @SerializedName("mechanicName")
    private String name;

    @SerializedName("mechanicAddress")
    private Endereco endereco;

    @SerializedName("mechanicSpeciality")
    private Especialidade especialidade;

}
