package io.ebpacheco.ipedidos.pedidos.repository;

import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
