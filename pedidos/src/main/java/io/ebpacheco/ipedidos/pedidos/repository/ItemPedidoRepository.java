package io.ebpacheco.ipedidos.pedidos.repository;

import io.ebpacheco.ipedidos.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
