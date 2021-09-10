package com.letscode.oficina.domain;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;



@Getter
@Setter
@Document

public class TelefoneCliente {

    @Id
    private String idTelefone;

    //TODO Verficar se temos mascaras para tratar telefones
    private String telefone;

    private Cliente cliente;





}
