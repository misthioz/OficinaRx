package com.letscode.oficina.transferobject.response;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.domain.OrdemServico;
import lombok.Getter;

@Getter
public class OrdemServicoResponse {

    private Integer id;
    private Carro carro;
    private Mecanico mecanico;
    private EnumStatus status;
    private String data;

    public OrdemServicoResponse(OrdemServico ordemServico){
        this.id = ordemServico.getId();
        this.carro = ordemServico.getCarro();
        this.mecanico = ordemServico.getMecanico();
        this.status = ordemServico.getStatus();
        this.data = ordemServico.getData();
    }

}
