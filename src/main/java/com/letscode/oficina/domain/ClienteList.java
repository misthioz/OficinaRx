package com.letscode.oficina.domain;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ClienteList {

    @SerializedName("results")
    public List<Cliente> clienteList;

    public String getClienteCount() {
        return "A quantidade de clientes é " + this.clienteList.size();
    }
}
