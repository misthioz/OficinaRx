package com.letscode.oficina.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity

public class TelefoneCliente {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTelefone;

    //TODO Verficar se temos mascaras para tratar telefones
    private String telefone;

    //TODO ler esse artigo sobre fetchtype https://www.devmedia.com.br/lazy-e-eager-loading-com-hibernate/29554
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;

//    @ManyToOne
//    @JoinColumn (name = "idCliente", referencedColumnName = "idCliente")
//    Cliente cliente;




}
