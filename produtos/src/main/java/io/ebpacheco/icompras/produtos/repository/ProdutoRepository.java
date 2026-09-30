package io.ebpacheco.icompras.produtos.repository;

import io.ebpacheco.icompras.produtos.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {


}
