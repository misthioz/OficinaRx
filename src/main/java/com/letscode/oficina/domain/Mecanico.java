package com.letscode.oficina.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @Id
    private Integer id;
    private String name;
    private Endereco endereco;
    private Especialidade especialidade;

}
