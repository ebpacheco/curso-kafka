package io.ebpacheco.ipedidos.pedidos.controller;

import io.ebpacheco.ipedidos.pedidos.controller.dto.NovoPedidoDTO;
import io.ebpacheco.ipedidos.pedidos.controller.mappers.PedidoMapper;
import io.ebpacheco.ipedidos.pedidos.repository.PedidoRepository;
import io.ebpacheco.ipedidos.pedidos.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pedidos")
@RequiredArgsConstructor
public class PedidoController {

    private final PedidoService service;
    private final PedidoMapper mapper;

    public ResponseEntity<Object> criar(@RequestBody NovoPedidoDTO dto) {
        var pedido = mapper.map(dto);
        var novoPedido = service.criarPedido(pedido);
        return ResponseEntity.ok(novoPedido);
    }

}
