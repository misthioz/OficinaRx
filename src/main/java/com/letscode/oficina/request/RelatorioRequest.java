package com.letscode.oficina.request;

import com.letscode.oficina.domain.OrdemServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RelatorioRequest {
    private String placaCarro;
}
