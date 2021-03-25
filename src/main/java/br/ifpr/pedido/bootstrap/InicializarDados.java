package br.ifpr.pedido.bootstrap;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Month;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.ifpr.pedido.dominio.Endereco;
import br.ifpr.pedido.dominio.Pedido;
import br.ifpr.pedido.dominio.PedidoItem;
import br.ifpr.pedido.dominio.Pessoa;
import br.ifpr.pedido.dominio.Produto;
import br.ifpr.pedido.repositories.PedidoRepository;
import br.ifpr.pedido.repositories.PessoaRepository;
import br.ifpr.pedido.repositories.ProdutoRepository;

@Component
public class InicializarDados implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// Incluir pessoa
		Pessoa pessoa1 = new Pessoa("Andre");
		pessoa1.setSobrenome("Garcia");
		pessoa1.setEmail("andrealvesgarcia@gmail.com");
		pessoa1.setDataNascimento(LocalDate.of(1972, Month.OCTOBER, 31));
		
		Endereco endereco1 = new Endereco();
		endereco1.setEnderecoLinha1("Rua Floresta, 713");
		endereco1.setEnderecoLinha2("Jardim Canaã");
		endereco1.setMunicipio("Paranavaí");
		endereco1.setEstado("Paraná");
		pessoa1.addEndereco(endereco1);
		
		pessoaRepository.save(pessoa1);
		
		
		// Incluir produto
		Produto produto1 = new Produto("Notebook Acer");
		produto1.setValor(7687.57);
		
		Produto produto2 = new Produto("Impressora 3D");
		produto2.setValor(3690.22);
		
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		
		// Incluir pedido
		LocalDate momentoAgora = LocalDate.now();
		Pedido pedido1 = new Pedido(momentoAgora);
		
		// Incluir item de pedido 1
		PedidoItem pedidoItem1 = new PedidoItem();
		pedidoItem1.setProduto(produto1);
		pedidoItem1.setQuantidade(2);
		pedidoItem1.setPedido(pedido1);
		
		// Incluir item de pedido 2
		PedidoItem pedidoItem2 = new PedidoItem();
		pedidoItem2.setProduto(produto2);
		pedidoItem2.setQuantidade(1);
		pedidoItem2.setPedido(pedido1);
		
		pedido1.addPedidoItem(pedidoItem1);
		pedido1.addPedidoItem(pedidoItem2);
		
		
		pedidoRepository.save(pedido1);
		
	}

}
