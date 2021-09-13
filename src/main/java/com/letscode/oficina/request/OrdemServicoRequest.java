package com.letscode.oficina.request;

import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.OrdemServico;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrdemServicoRequest {

    private Integer id;
    private String idCarro;
    private String idMecanico;
    private String idCliente;
    private EnumStatus status;
    private LocalDate data;

    public OrdemServico convert(){
        OrdemServico ordemServico = new OrdemServico();
        ordemServico.setId(this.id);
        ordemServico.setIdCarro(this.idCarro);
        ordemServico.setIdMecanico(this.idMecanico);
        ordemServico.setIdCliente(this.idCliente);
        ordemServico.setStatus(this.status);
        ordemServico.setData(this.data);
        return ordemServico;
    }

}
