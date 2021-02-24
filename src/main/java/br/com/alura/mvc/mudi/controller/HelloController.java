package br.com.alura.mvc.mudi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.annotation.RequestScope;

@Controller
@RequestScope
@RequestMapping("/hello")
public class HelloController {

	public HelloController() {
		// construtor padrão
	}

	@GetMapping
	public String hello() {
		return "hello";
	}
}