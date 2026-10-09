package io.ebpacheco.ipedidos.pedidos.validator;

import io.ebpacheco.ipedidos.pedidos.client.ClienteClients;
import io.ebpacheco.ipedidos.pedidos.client.ProdutosClient;
import io.ebpacheco.ipedidos.pedidos.model.ItemPedido;
import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    public final ProdutosClient produtosClient;
    public final ClienteClients clienteClients;

    public void validar(Pedido pedido) {
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);
    }

    public void validarCliente(Long codigoCliente) {

    }

    public void validarItem(ItemPedido itemPedido) {

    }
}
