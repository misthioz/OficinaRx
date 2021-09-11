package com.letscode.oficina.Request;

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




}
