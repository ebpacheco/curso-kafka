package io.ebpacheco.ipedidos.pedidos.controller.mappers;

import io.ebpacheco.ipedidos.pedidos.controller.dto.ItemPedidoDTO;
import io.ebpacheco.ipedidos.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {
    ItemPedido map(ItemPedidoDTO itemPedidoDTO);
}
