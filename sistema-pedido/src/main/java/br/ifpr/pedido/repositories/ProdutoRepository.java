package br.ifpr.pedido.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.ifpr.pedido.dominio.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@Query("select d from Produto d where lower(d.nome) like lower(concat(:termo, '%'))")
	List<Produto> searchByNome(@Param("termo") String termo);

}
