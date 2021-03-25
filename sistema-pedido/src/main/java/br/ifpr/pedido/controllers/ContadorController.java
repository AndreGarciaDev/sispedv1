package br.ifpr.pedido.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContadorController {
	
	// implementação
	private int contador = 1;

	@GetMapping("/contador")
	public String contador(HttpServletRequest req, Model model) {
		
		HttpSession session = req.getSession(true); // abre a sessao
		contador +=1;
		session.setAttribute("contador", contador); // salva uma variavel na sessao, com nome contador
		contador = (Integer) session.getAttribute("contador"); // recupera uma variavel com nome contador, gravada na sessao
		model.addAttribute("contador", contador);
		
		
		return "contador/contador";
	}
		
		

}
