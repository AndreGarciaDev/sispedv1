package br.ifpr.pedido.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IntroController {
	
	@GetMapping("/index")
	public String getPostNew() {
	    return "index";
	}

}
