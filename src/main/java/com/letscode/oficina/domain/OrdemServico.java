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
@Table ("OrdemServico")
public class OrdemServico {

    @Id
    private Integer id;
    private Carro carro;
    private Mecanico mecanico;
    private EnumStatus status;
    private String data;

}
