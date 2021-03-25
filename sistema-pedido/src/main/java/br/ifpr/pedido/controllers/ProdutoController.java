package br.ifpr.pedido.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpr.pedido.dominio.Produto;
import br.ifpr.pedido.repositories.ProdutoRepository;

@Controller
public class ProdutoController {
	
private ProdutoRepository produtoRepository;
	
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}
	
	@RequestMapping("/produtos")
	public String getProdutos(Model model) {
		
		model.addAttribute("produtos", produtoRepository.findAll());
		
		return "produtos/index";
	}
	
	@GetMapping("/produtos/novo")
	public String novoProduto(Produto produto) {
		return "produtos/editarProduto";
	}
	
	@GetMapping("/produtos/alterar/{id}")
	public String alterarProduto(@PathVariable("id") long id, Model model) {
		Produto produto = produtoRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Produto inválido"));
		
		model.addAttribute("produto", produto);
		return "produtos/editarProduto";
	}
	
	@GetMapping("/produtos/excluir/{id}")
	public String excluirProduto(@PathVariable("id") long id, Model model) {
		Produto produto = produtoRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Produto inválido"));
		
		produtoRepository.delete(produto);
		
		return "redirect:/produtos";
	}
	
	@PostMapping("/produtos/salvar")
	public String salvarProduto(@Valid Produto produto, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "produtos/editarProduto";
		}
		
		produtoRepository.save(produto);
		
		return "redirect:/produtos";
	}
	
}
