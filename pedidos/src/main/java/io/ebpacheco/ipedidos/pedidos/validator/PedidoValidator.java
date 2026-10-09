package io.ebpacheco.ipedidos.pedidos.validator;

import feign.FeignException;
import io.ebpacheco.ipedidos.pedidos.client.ClienteClients;
import io.ebpacheco.ipedidos.pedidos.client.ProdutosClient;
import io.ebpacheco.ipedidos.pedidos.client.representation.ClienteRepresentation;
import io.ebpacheco.ipedidos.pedidos.client.representation.ProdutoRepresentation;
import io.ebpacheco.ipedidos.pedidos.model.ItemPedido;
import io.ebpacheco.ipedidos.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    public final ProdutosClient produtosClient;
    public final ClienteClients clienteClients;

    public void validar(Pedido pedido) {
        Long codigoCliente = pedido.getCodigoCliente();
        validarCliente(codigoCliente);
        pedido.getItens().forEach(this::validarItem);
    }

    public void validarCliente(Long codigoCliente) {
        try {
            var response = clienteClients.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de codigo {} encontrado: {}", cliente.codigo(), cliente.nome());
        } catch (FeignException.NotFound e) {
            log.error("Cliente nao encontrado!");
        }

    }

    public void validarItem(ItemPedido itemPedido) {
        try {
            var response = produtosClient.obterDados(itemPedido.getCodigoProduto());
            ProdutoRepresentation produto = response.getBody();
            log.info("Produto de codigo {} encontrado: {}", produto.codigo(), produto.nome());
        } catch (FeignException.NotFound e) {
            log.error("Produto nao encontrado!");
        }
    }
}
