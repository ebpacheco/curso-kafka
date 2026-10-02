package io.ebpacheco.ipedidos.pedidos.controller.mappers;

import io.ebpacheco.ipedidos.pedidos.controller.dto.NovoPedidoDTO;
import io.ebpacheco.ipedidos.pedidos.model.Pedido;

public interface PedidoMapper {
    Pedido map(NovoPedidoDTO dto);
}
