package com.letscode.oficina.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("Mecanico")
public class Mecanico {

    @Id
    private Long id;
    private String name;
    private Endereco endereco;
    private List<Especialidade> especialidades;

}
