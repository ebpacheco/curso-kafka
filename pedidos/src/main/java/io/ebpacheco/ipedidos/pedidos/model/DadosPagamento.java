package io.ebpacheco.ipedidos.pedidos.model;

import io.ebpacheco.ipedidos.pedidos.model.enums.TipoPagamento;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DadosPagamento {
    private String dados;
    private TipoPagamento tipoPagamento;
}
