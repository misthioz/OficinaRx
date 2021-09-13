package com.letscode.oficina.response;

import com.letscode.oficina.domain.TelefoneCliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TelefoneClienteResponseMinimal {

    private String telefone;

    public TelefoneClienteResponseMinimal(TelefoneCliente telefoneCliente) {
        this.telefone = telefoneCliente.getTelefone();
    }

}
