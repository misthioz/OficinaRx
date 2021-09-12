package com.letscode.oficina.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Getter
@Setter
@NoArgsConstructor
//@Document
@Table("TelefoneCliente")
public class TelefoneCliente {

    @Id
    private String id;
    private String telefone;
    private String idCliente;

}
