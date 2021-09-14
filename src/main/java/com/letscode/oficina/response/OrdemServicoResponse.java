package com.letscode.oficina.response;

import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.OrdemServico;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdemServicoResponse {

    private Integer id;
    private String idCarro;
    private String placaCarro;
    private String marcaCarro;
    private String idMecanico;
    private String nomeMecanico;
    private String idCliente;
    private String nomeCliente;
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
