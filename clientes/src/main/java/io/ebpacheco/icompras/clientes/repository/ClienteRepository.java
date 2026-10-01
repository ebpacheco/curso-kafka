package io.ebpacheco.icompras.clientes.repository;

import io.ebpacheco.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
