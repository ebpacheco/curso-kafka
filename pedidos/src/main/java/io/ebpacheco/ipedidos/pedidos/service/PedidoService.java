package io.ebpacheco.ipedidos.pedidos.service;

import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import io.ebpacheco.ipedidos.pedidos.repository.ItemPedidoRepository;
import io.ebpacheco.ipedidos.pedidos.repository.PedidoRepository;
import io.ebpacheco.ipedidos.pedidos.validator.PedidoValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator pedidoValidator;

    public Pedido criarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
        return pedido;
    }
}
