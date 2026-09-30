package io.ebpacheco.icompras.produtos.controller;

import io.ebpacheco.icompras.produtos.model.Produto;
import io.ebpacheco.icompras.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> salvar(@RequestBody Produto produto){
        service.salvar(produto);
        return ResponseEntity.ok(produto);
    }

    @GetMapping
    public List<Produto> listarProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Produto> obterDados(@PathVariable("codigo")  Long codigo){
        return service
                .obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
