package com.letscode.oficina.transferobject.response;

import com.letscode.oficina.domain.Especialidade;
import lombok.Data;

@Data
public class EspecialidadeResponse {

    private Long id;
    private String nomeEspecialidade;
    private Long idMecanico;
    private String mecanicoNome;

    public static EspecialidadeResponse from(Especialidade especialidade) {
        EspecialidadeResponse especialidadeResponse = new EspecialidadeResponse();
        especialidadeResponse.setId(especialidade.getId());
        especialidadeResponse.setNomeEspecialidade(especialidade.getNomeEspecialidade());
        especialidadeResponse.setIdMecanico(especialidade.getIdMecanico());
        return especialidadeResponse;
    }

}
