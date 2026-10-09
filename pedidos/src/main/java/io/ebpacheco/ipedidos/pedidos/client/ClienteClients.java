package io.ebpacheco.ipedidos.pedidos.client;

import io.ebpacheco.ipedidos.pedidos.client.representation.ClienteRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes", url = "${icompras.pedidos.clients.clientes.url}")
public interface ClienteClients {

    @GetMapping("{codigo}")
    ResponseEntity<ClienteRepresentation> obterDadosPorCodigo(@PathVariable("codigo") Long codigo);
}
