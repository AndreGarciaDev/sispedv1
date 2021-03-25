package br.ifpr.pedido.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ifpr.pedido.dominio.Pedido;
import br.ifpr.pedido.dominio.PedidoItem;
import br.ifpr.pedido.dominio.Produto;
import br.ifpr.pedido.dto.AutoCompleteDTO;
import br.ifpr.pedido.repositories.PedidoRepository;
import br.ifpr.pedido.repositories.ProdutoRepository;

@Controller
public class PedidoController {
	
	private PedidoRepository pedidoRepository;
	private ProdutoRepository produtoRepositorio;
	private List<Produto> produtosFiltrados = new ArrayList<>();
	
	public PedidoController(PedidoRepository pedidoRepository, ProdutoRepository produtoRepositorio) {
		this.pedidoRepository = pedidoRepository;
		this.produtoRepositorio = produtoRepositorio;
	}
	
	
	@RequestMapping("/pedidos")
	public String getPedidos(Model model) {
		
		model.addAttribute("pedidos", pedidoRepository.findAll());
		
		return "pedidos/index";
	}
	
	@GetMapping("/pedidos/novo")
	public String novoPedido(Pedido pedido) {
		return "pedidos/editarPedido";
	}
	
	@GetMapping("/pedidos/alterar/{id}")
	public String alterarPedido(@PathVariable("id") long id, Model model) {
		Pedido pedido = pedidoRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Pedido inválido"));
		
		model.addAttribute("pedido", pedido);
		return "pedidos/editarPedido";
	}
	
	@GetMapping("/pedidos/excluir/{id}")
	public String excluirPedido(@PathVariable("id") long id, Model model) {
		Pedido pedido = pedidoRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Pedido inválido"));
		
		pedidoRepository.delete(pedido);
		
		return "redirect:/pedidos";
	}
	
	@PostMapping("/pedidos/salvar")
	public String salvarPedido(@Valid Pedido pedido, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "pedidos/editarPedido";
		}
		
		//Quando salvamos os objetos pedidoItem só vem preenchido com os dados do formulário, 
		//por isso precisamos setar a referencia ao objeto pedido
		for (PedidoItem pedidoItem : pedido.getItens()) {
			pedidoItem.setPedido(pedido);
		}
		
		pedidoRepository.save(pedido);
		
		return "redirect:/pedidos";
	}
	
	@RequestMapping(value="/pedidos/salvar", params = {"addPedidoItem"})
	public String addPedidoItem(Pedido pedido, BindingResult bindingResult) {
		pedido.addPedidoItem(new PedidoItem());
		return "pedidos/editarPedido";
	}
	
	@RequestMapping(value="/pedidos/salvar", params = {"removePedidoItem"})
	public String removePedidoItem(Pedido pedido, BindingResult bindingResult, HttpServletRequest req) {
		final Integer itemIndex = Integer.valueOf(req.getParameter("removePedidoItem"));
		
		pedido.removePedidoItem(itemIndex.intValue());
		return "pedidos/editarPedido";
	}
	
	
	@RequestMapping("/pedidos/produtosNomeAutoComplete")
	@ResponseBody
	public List<AutoCompleteDTO> produtosNomeAutoComplete(
			@RequestParam(value = "term", required = false, defaultValue = "") String term) {
		List<AutoCompleteDTO> sugestoes = new ArrayList<>();
		try {
			if (term.length() >= 2) {
				produtosFiltrados = produtoRepositorio.searchByNome(term);
			}

			for (Produto produto : produtosFiltrados) {
				if (produto.getNome().toLowerCase().contains(term.toLowerCase())) {
					sugestoes.add(new AutoCompleteDTO(produto.getNome(), Long.toString(produto.getId())));
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return sugestoes;
	}
	
}
