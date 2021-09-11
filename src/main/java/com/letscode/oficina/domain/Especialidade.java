package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Especialidade")
public class Especialidade {

    @Id
    private String id;
    private String especialidade;

}

// ENGINE_REPAIR,
// ENGINE_PERFORMANCE,
// AUTOMATIC_TRANSMISSION,
// BRAKES,
// ELECTRONIC_SYSTEMS,
// HEATING_AC,
// MANUAL_DRIVE_TRAIN_AXLES,
// SUSPENSION_STEERING