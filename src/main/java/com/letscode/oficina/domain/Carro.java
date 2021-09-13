package com.letscode.oficina.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@Table("Carro")
public class Carro {

    @Id
    private String id;
    private String placa;
    private String marca;
    private String cor;
    @Column("id_cliente")
    private String idCliente;

}
