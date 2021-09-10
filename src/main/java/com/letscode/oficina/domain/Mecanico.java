package com.letscode.oficina.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {

    @Id
    private String id;
    private String name;
    private Endereco endereco;

    private List<Especialidade> especialidade;

}
