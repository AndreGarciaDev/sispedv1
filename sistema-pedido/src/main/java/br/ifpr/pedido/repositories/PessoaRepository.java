package br.ifpr.pedido.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import br.ifpr.pedido.dominio.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
