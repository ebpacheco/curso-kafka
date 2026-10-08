package io.ebpacheco.ipedidos.pedidos.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "io.ebpacheco.ipedidos.pedidos.client")
public class ClientsConfig {

}
