package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
public class LoginController {

	public LoginController() {
		// construtor padrão
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
