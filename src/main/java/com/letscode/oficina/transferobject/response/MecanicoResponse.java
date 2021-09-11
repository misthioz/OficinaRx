package com.letscode.oficina.transferobject.response;

import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.transferobject.EspecialidadeTO;
import com.letscode.oficina.transferobject.request.MecanicoRequest;
import lombok.Data;

@Data
public class MecanicoResponse extends MecanicoRequest {

    private Long id;
    private EspecialidadeTO especialidadeTO;

    public static MecanicoResponse from(Mecanico mecanico) {
        MecanicoResponse mecanicoResponse = new MecanicoResponse();
        mecanicoResponse.setId(mecanico.getId());
        mecanicoResponse.setNome(mecanico.getName());
        mecanicoResponse.setEspecialidades(mecanico.getEspecialidades());
        return mecanicoResponse;
    }

}
