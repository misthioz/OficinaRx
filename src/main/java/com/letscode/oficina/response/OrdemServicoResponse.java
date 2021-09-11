package com.letscode.oficina.response;

import com.letscode.oficina.domain.Carro;
import com.letscode.oficina.domain.EnumStatus;
import com.letscode.oficina.domain.Mecanico;
import com.letscode.oficina.domain.OrdemServico;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class OrdemServicoResponse {

    private Integer id;
    private Carro carro;
    private Mecanico mecanico;
    private EnumStatus status;
    private String data;



}
