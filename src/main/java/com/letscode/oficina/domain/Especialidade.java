package com.letscode.oficina.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("especialidade")
@Data
public class Especialidade {

    @Id
    @Column("id")
    private Long id;
    @Column("especialidade")
    private String nomeEspecialidade;
    @Column("id_mecanico")
    private Long idMecanico;

}

// ENGINE_REPAIR,
// ENGINE_PERFORMANCE,
// AUTOMATIC_TRANSMISSION,
// BRAKES,
// ELECTRONIC_SYSTEMS,
// HEATING_AC,
// MANUAL_DRIVE_TRAIN_AXLES,
// SUSPENSION_STEERING