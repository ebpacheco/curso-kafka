package io.ebpacheco.ipedidos.pedidos.controller.dto;

import io.ebpacheco.ipedidos.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}
