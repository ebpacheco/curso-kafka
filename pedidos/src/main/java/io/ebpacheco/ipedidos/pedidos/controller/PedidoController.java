package io.ebpacheco.ipedidos.pedidos.controller;

import io.ebpacheco.ipedidos.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import io.ebpacheco.ipedidos.pedidos.controller.dto.NovoPedidoDTO;
import io.ebpacheco.ipedidos.pedidos.controller.mappers.PedidoMapper;
import io.ebpacheco.ipedidos.pedidos.model.ErroResposta;
import io.ebpacheco.ipedidos.pedidos.model.exception.ItemNaoEncontradoException;
import io.ebpacheco.ipedidos.pedidos.model.exception.ValidationException;
import io.ebpacheco.ipedidos.pedidos.publisher.DetalhePedidoMapper;
import io.ebpacheco.ipedidos.pedidos.publisher.representation.DetalhePedidoRepresentation;
import io.ebpacheco.ipedidos.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper pedidoMapper;
    private final DetalhePedidoMapper detalhePedidoMapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        try {
            var pedido = pedidoMapper.map(dto);
            var novoPedido = service.criarPedido(pedido);
            return ResponseEntity.ok(novoPedido.getCodigo());
        }catch (ValidationException e) {
            var erro = new ErroResposta("Erro de validacao", e.getMessage(), e.getField());
            return ResponseEntity.badRequest().body(erro);
        }

    }

    @PostMapping("/pagamentos")
    public ResponseEntity<Object> adicionarNovoPagamento(@RequestBody AdicaoNovoPagamentoDTO dto) {
        try {
            service.adicionarNovoPagamento(dto.codigoPedido(), dto.dados(), dto.tipoPagamento());
            return ResponseEntity.noContent().build();
        } catch (ItemNaoEncontradoException e) {
            var erro = new ErroResposta("Item nao encontrad", "codigoPedido", e.getMessage());
            return ResponseEntity.badRequest().body(erro);
        }
    }

    @GetMapping("{codigo}")
    public ResponseEntity<DetalhePedidoRepresentation> obterDetalhesPedido(@PathVariable("codigo") Long codigo){
        return service
                .carregarDadosCompletoPedido(codigo)
                .map(detalhePedidoMapper::map)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
