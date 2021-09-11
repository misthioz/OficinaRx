package com.letscode.oficina.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
//@Document
@Table("TelefoneCliente")
public class TelefoneCliente {

    @Id
    private String id;
    private String telefone;
    private String idCliente;

    public TelefoneCliente(String telefone,String id){
        this.telefone = telefone;
        this.idCliente = id;
    }

    public TelefoneCliente() {

    }

}
