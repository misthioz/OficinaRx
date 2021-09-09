package com.letscode.oficina.response;

import com.letscode.oficina.domain.Especialidade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MecanicoResponse {

    private String nome;
    private Especialidade especialidade;

}
