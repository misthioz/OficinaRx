package com.letscode.oficina.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Table ("OrdemServico")
public class OrdemServico {

    @Id
    private Integer id;
    @Column("id_Carro")
    private String idCarro;
    @Column("id_Mecanico")
    private String idMecanico;
    @Column("id_Cliente")
    private String idCliente;
    private EnumStatus status;
    private LocalDate data;

}
