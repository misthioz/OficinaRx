package com.letscode.oficina.transferobject.request;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.domain.OrdemServico;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class OrdemServicoRequest {

    private Integer id;
    private Carro carro;
    private Mecanico mecanico;
    private EnumStatus status;
    private String data;
    //TODO adicionar cliente

    public OrdemServico convert(){
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setId(this.id);
        ordemServico.setCarro(this.carro);
        ordemServico.setMecanico(this.mecanico);
        ordemServico.setStatus(this.status);
        ordemServico.setData(this.data);
        return ordemServico;
    }

}
