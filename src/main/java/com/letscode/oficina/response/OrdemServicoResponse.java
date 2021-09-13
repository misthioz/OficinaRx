package com.letscode.oficina.response;

import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.OrdemServico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrdemServicoResponse {

    private Integer id;
    private String idCarro;
    private String idMecanico;
    private String idCliente;
    private EnumStatus status;
    private LocalDate data;

    public OrdemServicoResponse(OrdemServico ordemServico){
        this.id = ordemServico.getId();
        this.idCarro = ordemServico.getIdCarro();
        this.idMecanico = ordemServico.getIdMecanico();
        this.idCliente = ordemServico.getIdCliente();
        this.status = ordemServico.getStatus();
        this.data = ordemServico.getData();
    }

}
