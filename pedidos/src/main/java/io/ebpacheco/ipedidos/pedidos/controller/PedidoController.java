package io.ebpacheco.ipedidos.pedidos.controller;

import io.ebpacheco.ipedidos.pedidos.controller.dto.AdicaoNovoPagamentoDTO;
import io.ebpacheco.ipedidos.pedidos.controller.dto.NovoPedidoDTO;
import io.ebpacheco.ipedidos.pedidos.controller.mappers.PedidoMapper;
import io.ebpacheco.ipedidos.pedidos.model.ErroResposta;
import io.ebpacheco.ipedidos.pedidos.model.exception.ItemNaoEncontradoException;
import io.ebpacheco.ipedidos.pedidos.model.exception.ValidationException;
import io.ebpacheco.ipedidos.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    @PostMapping
    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        try {
            var pedido = mapper.map(dto);
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

}
