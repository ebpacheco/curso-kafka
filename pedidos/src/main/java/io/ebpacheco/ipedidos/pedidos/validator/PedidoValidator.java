package io.ebpacheco.ipedidos.pedidos.validator;

import io.ebpacheco.ipedidos.pedidos.client.ProdutosClient;
import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    public final ProdutosClient produtosClient;

    public void validar(Pedido pedido) {
    }
}
