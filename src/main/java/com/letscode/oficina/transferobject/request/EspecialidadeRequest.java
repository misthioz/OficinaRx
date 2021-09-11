package com.letscode.oficina.transferobject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeRequest {

    private Long id;
    private String nomeEspecialidade;
    private Long idMecanico;

}
