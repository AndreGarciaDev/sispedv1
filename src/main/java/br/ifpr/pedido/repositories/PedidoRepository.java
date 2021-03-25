package br.ifpr.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpr.pedido.dominio.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
