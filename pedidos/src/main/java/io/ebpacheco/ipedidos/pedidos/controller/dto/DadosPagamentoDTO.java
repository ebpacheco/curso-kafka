package io.ebpacheco.ipedidos.pedidos.controller.dto;

import io.ebpacheco.ipedidos.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados,
        TipoPagamento tipoPagamento) {
}
