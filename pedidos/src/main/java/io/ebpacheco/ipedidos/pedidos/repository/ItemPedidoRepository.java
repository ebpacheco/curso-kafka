package io.ebpacheco.ipedidos.pedidos.repository;

import io.ebpacheco.ipedidos.pedidos.model.ItemPedido;
import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedido(Pedido pedido);
}
