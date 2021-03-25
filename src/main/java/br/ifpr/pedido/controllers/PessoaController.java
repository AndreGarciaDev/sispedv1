package br.ifpr.pedido.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ifpr.pedido.dominio.Pessoa;
import br.ifpr.pedido.dominio.Endereco;
import br.ifpr.pedido.dominio.Telefone;
import br.ifpr.pedido.repositories.PessoaRepository;

@Controller
public class PessoaController {

	private PessoaRepository pessoaRepository;
	
	public PessoaController(PessoaRepository pessoaRepository) {
		this.pessoaRepository = pessoaRepository;
	}
	
	@RequestMapping("/pessoas")
	public String getPessoas(Model model) {
		
		model.addAttribute("pessoas", pessoaRepository.findAll());
		
		return "pessoas/index";
	}
	
	@GetMapping("/pessoas/novo")
	public String novoPessoa(Pessoa pessoa) {
		return "pessoas/editarPessoa";
	}
	
	@GetMapping("/pessoas/alterar/{id}")
	public String alterarPessoa(@PathVariable("id") long id, Model model) {
		Pessoa pessoa = pessoaRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Cliente inválido"));
		
		model.addAttribute("pessoa", pessoa);
		return "pessoas/editarPessoa";
	}
	
	@GetMapping("/pessoas/excluir/{id}")
	public String excluirPessoa(@PathVariable("id") long id, Model model) {
		Pessoa pessoa = pessoaRepository.findById(id)
											.orElseThrow(() -> new IllegalArgumentException("Cliente inválido"));
		
		pessoaRepository.delete(pessoa);
		
		return "redirect:/pessoas";
	}
	
	@PostMapping("/pessoas/salvar")
	public String salvarPessoa(@Valid Pessoa pessoa, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "pessoas/editarPessoa";
		}
		
		pessoa.corrigirEnderecosTelefones();
		
		pessoaRepository.save(pessoa);
		
		return "redirect:/pessoas";
	}
	
	@RequestMapping(value="/pessoas/salvar", params = {"addEndereco"})
	public String addEndereco(Pessoa pessoa, BindingResult bindingResult) {
		pessoa.addEndereco(new Endereco());
		return "pessoas/editarPessoa";
	}
	
	@RequestMapping(value="/pessoas/salvar", params = {"removeEndereco"})
	public String removeEndereco(Pessoa pessoa, BindingResult bindingResult, HttpServletRequest req) {
		final Integer enderecoIndex = Integer.valueOf(req.getParameter("removeEndereco"));
		
		pessoa.removeEndereco(enderecoIndex.intValue());
		return "pessoas/editarPessoa";
	}
	
	@RequestMapping(value="/pessoas/salvar", params = {"addTelefone"})
	public String addTelefone(Pessoa pessoa, BindingResult bindingResult) {
		pessoa.addTelefone(new Telefone());
		return "pessoas/editarPessoa";
	}
	
}
